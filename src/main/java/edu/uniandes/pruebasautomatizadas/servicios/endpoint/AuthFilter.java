package edu.uniandes.pruebasautomatizadas.servicios.endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.uniandes.pruebasautomatizadas.servicios.comun.Identificacion;
import edu.uniandes.pruebasautomatizadas.servicios.comun.RequestScope;
import edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface.UsuarioRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.SeguridadControl;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import edu.uniandes.pruebasautomatizadas.servicios.service.security.iface.SeguridadControlService;

/**
 * Filtro que controla la autorizacion a los servicios REST.
 *
 */
@Component
public class AuthFilter implements Filter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Nombre de la cabecera que contendra el token de autenticacion.
	 */
	private static final String AUTH_HEADER = "Authorization";
	/**
	 * Prefijo del contenido de la cabecera de autenticacion.
	 */
	private static final String AUTH_BEARER = "Bearer";
	/**
	 * Peticiones que no requieren autenticacion.
	 */
	private static final List<Peticion> SIN_AUTH = new ArrayList<>();

	private static final String AUTH_USER_HEADER = "UserKey";
	private static final String AUTH_PASSWORD_HEADER = "PasswordKey";
	
	/**
	 * RequestScope Permite obtener almacenar el usuario de la peticion.
	 */
	@Autowired
	private RequestScope requestScope;
	
	@Autowired
	private SeguridadControlService seguridadControlService;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * Codigo HTTP de status FORBIDDEN.
	 */
	private static final int FORBIDDEN = 403;

	/**
	 * Constructor.
	 */
	public AuthFilter() {
		/**
		 * EndPoint Modulo Catalogo
		 */
		SIN_AUTH.add(new Peticion(RequestMethod.GET, "catalogo/empresa"));
		SIN_AUTH.add(new Peticion(RequestMethod.GET, "catalogo/usuario"));
		SIN_AUTH.add(new Peticion(RequestMethod.GET, "version"));

	}

	/**
	 * Nombre de la llave del request donde se almacena el objetivo Identidad
	 * para poder obtenerlo en los demas controladores.
	 */
	private static final String AUTH_KEY = "IDENTIDAD";

	/**
	 * Inicializacion del filtro.
	 *
	 * @param fc
	 *            FilterConfig
	 * @throws ServletException
	 */
	@Override
	public void init(final FilterConfig fc) throws ServletException {
	}

	/**
	 * Logica a ejecutar en el filtro.
	 *
	 * @param req
	 *            ServletRequest
	 * @param res
	 *            ServletResponse
	 * @param chain
	 *            FilterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		// Solo se interceptan las peticiones de tipo GET, POST, UPDATE o DELETE
		// ya que los navegadores pueden utilizar OPTIONS u otro tipo de peticion para
		// verificar el estado del servicio
		String metodo = request.getMethod().toUpperCase();
		
		
		if (metodo.equals("GET") || metodo.equals("POST") || metodo.equals("PUT") || metodo.equals("UPDATE")
			|| metodo.equals("DELETE")) {
		
			//TODO logica para bloqueo de peticiones por IP's
			Long peticiones = seguridadControlService.contarPorIpYRangoFecha(req.getRemoteAddr(), new Date(System.currentTimeMillis() - 300 * 1000), new Date());
			SeguridadControl seg = new SeguridadControl();
			seg.setFecha(new Date());
			seg.setIp(req.getRemoteAddr());
			seguridadControlService.guardarRegistro(seg);
		
			if (validarEInyectarAutorizacion(request)) {
				chain.doFilter(req, res);
			} else {
				HttpServletResponse response = (HttpServletResponse) res;
				response.sendError(FORBIDDEN, "No permitido, autenticación inválida");				
			}
		} else {
			chain.doFilter(req, res);
		}
	}

	/**
	 * Destroy del filtro.
	 */
	@Override
	public void destroy() {

	}

	/**
	 * Valida la autorizacion de acceso a la URL solicitada e inyecta la
	 * identidad en el request para poder utilizarla en los demas controladores
	 * de la aplicacion.
	 *
	 * @param request
	 *            HttpServletRequest. El request debe contener una cabecera HTTP
	 *            de la forma Authorization: Bearer <token>
	 * @return true si el acceso es permitido e inyecta la identidad en el
	 *         request. De lo contrario retorna false.
	 */
	private boolean validarEInyectarAutorizacion(final HttpServletRequest request) {
		boolean autorizado = false;
		String header = request.getHeader(AUTH_HEADER);
		for (Peticion peticion : SIN_AUTH) {
			if (peticion.match(request)) {
				autorizado = true;
				log.info("Método: "+peticion.metodo+" url: "+peticion.url);
				break;
			}
		}
		if (!autorizado) {
			// Todos los demas servicios requieren que se envie la cadena Bearer
			// <token>
//			if (StringUtils.isNotBlank(header)) {
				if (verificarCredenciales(request)){
					autorizado = true;
				}
//				String[] tmpTokens = header.split(AUTH_BEARER);
//				if (tmpTokens.length == 2) {
//					String token = tmpTokens[1];
//					Optional<Identificacion> ident = validarToken(StringUtils.trimToEmpty(token));
//					if (ident.isPresent()) {
//						requestScope.setIdentificacion(ident.get());
//						request.setAttribute(AUTH_KEY, ident.get());
//					}
//					autorizado = ident.isPresent();
//				}
//			}
		}
		requestScope.setIp(request.getRemoteAddr());
		return autorizado;
	}

	private boolean verificarCredenciales(final HttpServletRequest request) {
		boolean result = false; 
		String userHeader = request.getHeader(AUTH_USER_HEADER);
		String passwordHeader = request.getHeader(AUTH_PASSWORD_HEADER);
		Usuario usuario 
			= usuarioRepository.findByCodigoUsuarioAndContrasena(userHeader, passwordHeader);
		
		if(usuario!= null) {
			if(usuario.getNombreUsuario()!=null) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Valida el token JWT.
	 *
	 * @param token
	 *            Cadena con el token en formato JWT.
	 * @return Optional con la identificacion. Si el token es invalido retorna
	 *         un Optional vacio.
	 */
	private Optional<Identificacion> validarToken(final String token) {
		if (token != null && !token.isEmpty()) {
			// TODO Obtener el ID del token de keycloak
			return Optional.of(new Identificacion(0));
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Clase que representa una peticion HTTP.
	 */
	private final class Peticion {

		/**
		 * Metodo HTTP.
		 */
		private final RequestMethod metodo;
		/**
		 * URL solicitada.
		 */
		private final String url;

		/**
		 * Constructor.
		 *
		 * @param metodo
		 *            RequestMethod de la peticion.
		 * @param url
		 *            Url de la peticion.
		 */
		Peticion(final RequestMethod metodo, final String url) {
			this.metodo = metodo;
			this.url = url;
		}

		/**
		 * Valida si el metodo y la url de la peticion establecidas en el
		 * constructor conciden con el HttpServletRequest.
		 * 
		 * @param request
		 *            HttpServletRequest
		 * @return true si coninciden, de lo contrario false.
		 */
		boolean match(final HttpServletRequest request) {
			String lMetodo = request.getMethod().toUpperCase();
			String lUrl = request.getRequestURL().toString();
			return lMetodo.equals(this.metodo.toString()) && lUrl.contains(this.url);
		}

	}
}
