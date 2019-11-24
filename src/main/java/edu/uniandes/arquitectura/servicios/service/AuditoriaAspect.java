package edu.uniandes.arquitectura.servicios.service;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import edu.uniandes.arquitectura.servicios.comun.DateTimeUtil;
import edu.uniandes.arquitectura.servicios.comun.RequestScope;
import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.AutorizacionGarantiaRepository;
import edu.uniandes.arquitectura.servicios.dao.model.Auditoria;
import edu.uniandes.arquitectura.servicios.dao.model.AutorizacionGarantia;
import edu.uniandes.arquitectura.servicios.dao.model.Trazabilidad;
import edu.uniandes.arquitectura.servicios.service.log.iface.AuditoriaService;
import edu.uniandes.arquitectura.servicios.service.log.iface.TrazabilidadService;

/**
 * Aspecto que permite almacenar el log de auditoria de todas las peticiones y
 * respuestas a las clases de negocio (aquellas que se encuentran dentro del
 * paquete edu.uniandes.arquitectura.servicios.service).
 *
 */
@Aspect
@Component
public class AuditoriaAspect {

	/**
	 * Logger.
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AutorizacionGarantiaRepository autorizacionGarantiaRepository;

	@Autowired
	private AuditoriaService auditoriaService;

	/**
	 * RequestScope.
	 */
	@Autowired
	private RequestScope requestScope;

	@Autowired
	private TrazabilidadService trazabilidadService;

	/**
	 * Timezone de la aplicacion.
	 */
	@Value("${servicios.timezone}")
	private String timezone;

	/**
	 * Pointcut de los servicios.
	 */
	@Pointcut("within(edu.uniandes.arquitectura.servicios.service.catalogo..*)")
	public void loggingPointcut() {
		// Method is empty as this is just a Poincut, the implementations are in
		// the advices.
	}

	@Pointcut("within(edu.uniandes.arquitectura.servicios.dao.catalogo..*) || "
			+ "execution(* org.springframework.data.repository.CrudRepository+.save(*)) || "
			+ "execution(* org.springframework.data.repository.CrudRepository+.saveAndFlush(*))"
			+ "execution(* org.springframework.data.jpa.repository.JpaRepository+.save(*))"
			+ "execution(* org.springframework.data.jpa.repository.JpaRepository+.saveAndFlush(*))"
			+ "execution(* org.springframework.data.jpa.repository.JpaRepository+.save(*))")
	public void auditPointcut() {
		// Method is empty as this is just a Poincut, the implementations are in
		// the advices.
	}

	/**
	 * Loguea todas las peticiones de solicitud (request) junto con la respuesta
	 * (response) utilizando el siguiente formano separado por el caracter
	 * tuberia: <br>
	 * peticion|fecha|ip|tran|ident|paquete_interfaz|nombre_interfaz|metodo|mensaje<br>
	 * Donde: <br>
	 * peticion: request o response. Por cada peticion se almacena tanto la
	 * solicitud como la respuesta del metodo.<br>
	 * fecha: Fecha de la peticion.<br>
	 * ip: direccion IP del cliente que realiza la peticion.<br>
	 * . tran: numero de transaccion para correlacionar la peticion con la
	 * respuesta.<br>
	 * ident: el identificador del usuario que realiza la peticion.<br>
	 * paquete_interfaz: el nombre del paquete de la interfaz el cual
	 * corresponde al modulo.<br>
	 * nombre_interfaz: el nombre de la interfaz el cual corresponde a la
	 * funcion.<br>
	 * metodo: nombre del metodo solicitado el cual corresponde a la
	 * funcion.<br>
	 * mensaje: si es la peticion almacena los parametros de la peticion. Si es
	 * la respuesta almacena el resultado de la peticion.
	 * 
	 * @param ProceedingJoinPoint.
	 * @throws Throwable
	 * @return Retorno del metodo.
	 */
	@Around("loggingPointcut()")
	public Object logAround(final ProceedingJoinPoint joinPoint) throws Throwable {
		String formato = "{}|{}|{}|{}|{}|{}|{}|{}|{}";
		String nivelTraza = "INFO";
		String mensaje = "";

		log.info(formato, "request", DateTimeUtil.nowAsString(timezone), requestScope.getIp(),
				requestScope.getTransaccion(), normalizarIdentificacion(),
				joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getPackage().getName(),
				joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getSimpleName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			log.info(formato, "response", DateTimeUtil.nowAsString(timezone), requestScope.getIp(),
					requestScope.getTransaccion(), normalizarIdentificacion(),
					joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getPackage().getName(),
					joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getSimpleName(),
					joinPoint.getSignature().getName(), result);
			mensaje = joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getPackage().getName() + " "
					+ joinPoint.getSignature().getDeclaringType().getInterfaces()[0].getSimpleName() + " "
					+ joinPoint.getSignature().getName() + " " + Arrays.toString(joinPoint.getArgs());
			return result;
		} catch (Exception e) {
			log.info(formato, "response", DateTimeUtil.nowAsString(timezone), requestScope.getIp(),
					requestScope.getTransaccion(), normalizarIdentificacion(), "Exception", "", "", e.getMessage());
			nivelTraza = "ERROR";
			mensaje = " Exception - " + e.getMessage();
			throw e;
		} finally {
			Trazabilidad trazabilidad = new Trazabilidad();
			trazabilidad.setFecha(new Date());
			trazabilidad.setNivelTraza(nivelTraza);
			trazabilidad.setMensaje(mensaje.length() >= 4000 ? mensaje.substring(1, 3999) : mensaje);

			trazabilidadService.guardarTraza(trazabilidad);
		}

	}

	@Around("auditPointcut()")
	public Object auditAround(final ProceedingJoinPoint joinPoint) throws Throwable {
		Date fecha = new Date();
		String tablaModificada = "";
		Long registroModificado = 0L;
		String accion = "";
		String campoModificado = "";
		String valorAntiguo = "";
		String valorNuevo = "";

		Object[] argu = joinPoint.getArgs();

		for (Object object : argu) {
			if (object instanceof AutorizacionGarantia) {
				AutorizacionGarantia autorizacionAudit = (AutorizacionGarantia) object;
				tablaModificada = "AUTORIZACION_GARANTIA";
				if (autorizacionAudit.getIdAutorizacion() != null) {
					if (autorizacionAudit.getIdAutorizacion() > 0L) {
						AutorizacionGarantia anterior = autorizacionGarantiaRepository
								.findByIdAutorizacion(autorizacionAudit.getIdAutorizacion());
						if (anterior != null) {
							if (anterior.getIdAutorizacion() > 0L) {
								if (!anterior.getCodigoAutorizacion()
										.equalsIgnoreCase(autorizacionAudit.getCodigoAutorizacion())) {
									accion = "U";
									campoModificado = "CODIGO_AUTORIZACION";
									valorAntiguo = anterior.getCodigoAutorizacion();
									valorNuevo = autorizacionAudit.getCodigoAutorizacion();
									registroModificado = anterior.getIdAutorizacion();
									auditoriaService
											.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
													campoModificado, fecha, valorAntiguo, valorNuevo, accion));
								}

								if (!anterior.getEspecificacionAutorizacion()
										.equalsIgnoreCase(autorizacionAudit.getEspecificacionAutorizacion())) {
									accion = "U";
									campoModificado = "ESPECIFICACION_AUTORIZACION";
									valorAntiguo = anterior.getEspecificacionAutorizacion();
									valorNuevo = autorizacionAudit.getEspecificacionAutorizacion();
									registroModificado = anterior.getIdAutorizacion();
									auditoriaService
											.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
													campoModificado, fecha, valorAntiguo, valorNuevo, accion));
								}

								if (!anterior.getEstado().equalsIgnoreCase(autorizacionAudit.getEstado())) {
									accion = "U";
									campoModificado = "ESTADO";
									valorAntiguo = anterior.getEstado();
									valorNuevo = autorizacionAudit.getEstado();
									registroModificado = anterior.getIdAutorizacion();
									auditoriaService
											.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
													campoModificado, fecha, valorAntiguo, valorNuevo, accion));
								}

								if (anterior.getEmpleado().getId() != autorizacionAudit.getEmpleado().getId()) {
									accion = "U";
									campoModificado = "EMPLEADO";
									valorAntiguo = anterior.getEmpleado().getId().toString();
									valorNuevo = autorizacionAudit.getEmpleado().getId().toString();
									registroModificado = anterior.getIdAutorizacion();
									auditoriaService
											.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
													campoModificado, fecha, valorAntiguo, valorNuevo, accion));
								}

								if (anterior.getGarantia().getIdGarantia() != autorizacionAudit.getGarantia()
										.getIdGarantia()) {
									accion = "U";
									campoModificado = "GARANTIA";
									valorAntiguo = anterior.getGarantia().getIdGarantia().toString();
									valorNuevo = autorizacionAudit.getGarantia().getIdGarantia().toString();
									registroModificado = anterior.getIdAutorizacion();
									auditoriaService
											.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
													campoModificado, fecha, valorAntiguo, valorNuevo, accion));
								}

							} else {
								// no hay id de autorizacion es registro nuevo
								accion = "I";
								campoModificado = "EMPLEADO";
								valorAntiguo = autorizacionAudit.getEmpleado().getId().toString();
								valorNuevo = autorizacionAudit.getEmpleado().getId().toString();
								auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada,
										registroModificado, campoModificado, fecha, valorAntiguo, valorNuevo, accion));

								campoModificado = "GARANTIA";
								valorAntiguo = autorizacionAudit.getGarantia().getIdGarantia().toString();
								valorNuevo = autorizacionAudit.getGarantia().getIdGarantia().toString();
								auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada,
										registroModificado, campoModificado, fecha, valorAntiguo, valorNuevo, accion));

								campoModificado = "ESTADO";
								valorAntiguo = autorizacionAudit.getEstado();
								valorNuevo = autorizacionAudit.getEstado();
								auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada,
										registroModificado, campoModificado, fecha, valorAntiguo, valorNuevo, accion));

								campoModificado = "ESPECIFICACION_AUTORIZACION";
								valorAntiguo = autorizacionAudit.getEspecificacionAutorizacion();
								valorNuevo = autorizacionAudit.getEspecificacionAutorizacion();
								auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada,
										registroModificado, campoModificado, fecha, valorAntiguo, valorNuevo, accion));

								campoModificado = "CODIGO_AUTORIZACION";
								valorAntiguo = autorizacionAudit.getCodigoAutorizacion();
								valorNuevo = autorizacionAudit.getCodigoAutorizacion();
								auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada,
										registroModificado, campoModificado, fecha, valorAntiguo, valorNuevo, accion));

							}
						} else {
							// No se recupera registro anterior entonces es
							// nuevo
							accion = "I";
							campoModificado = "EMPLEADO";
							valorAntiguo = autorizacionAudit.getEmpleado().getId().toString();
							valorNuevo = autorizacionAudit.getEmpleado().getId().toString();
							auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
									campoModificado, fecha, valorAntiguo, valorNuevo, accion));

							campoModificado = "GARANTIA";
							valorAntiguo = autorizacionAudit.getGarantia().getIdGarantia().toString();
							valorNuevo = autorizacionAudit.getGarantia().getIdGarantia().toString();
							auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
									campoModificado, fecha, valorAntiguo, valorNuevo, accion));

							campoModificado = "ESTADO";
							valorAntiguo = autorizacionAudit.getEstado();
							valorNuevo = autorizacionAudit.getEstado();
							auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
									campoModificado, fecha, valorAntiguo, valorNuevo, accion));

							campoModificado = "ESPECIFICACION_AUTORIZACION";
							valorAntiguo = autorizacionAudit.getEspecificacionAutorizacion();
							valorNuevo = autorizacionAudit.getEspecificacionAutorizacion();
							auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
									campoModificado, fecha, valorAntiguo, valorNuevo, accion));

							campoModificado = "CODIGO_AUTORIZACION";
							valorAntiguo = autorizacionAudit.getCodigoAutorizacion();
							valorNuevo = autorizacionAudit.getCodigoAutorizacion();
							auditoriaService.guardarAuditoria(this.buildAuditoria(tablaModificada, registroModificado,
									campoModificado, fecha, valorAntiguo, valorNuevo, accion));
						}
					}
				}
			}

		}

		Object result = joinPoint.proceed();
		return result;
	}

	private Auditoria buildAuditoria(String tablaModificada, Long registroModificado, String campoModificado,
			Date fecha, String valorAntiguo, String valorNuevo, String accion) {

		Auditoria auditoria = new Auditoria();
		auditoria.setTablaModificada(tablaModificada);
		auditoria.setRegistroModificado(registroModificado);
		auditoria.setCampoModificado(campoModificado);
		auditoria.setFecha(fecha);
		auditoria.setValorAntiguo(valorAntiguo);
		auditoria.setValorNuevo(valorNuevo);
		auditoria.setAccion(accion);
		return auditoria;
	}

	/**
	 * Retorna el identificador del usuario. Si el usuario es nulo retorna una
	 * cadena vacia.
	 *
	 * @return Cadena con el id del usuario.
	 */
	private String normalizarIdentificacion() {
		if (requestScope.getIdentificacion() != null && requestScope.getIdentificacion().getId() != null) {
			return String.valueOf(requestScope.getIdentificacion().getId());
		} else {
			return "";
		}
	}

	public AutorizacionGarantiaRepository getAutorizacionGarantiaRepository() {
		return autorizacionGarantiaRepository;
	}

	public void setAutorizacionGarantiaRepository(AutorizacionGarantiaRepository autorizacionGarantiaRepository) {
		this.autorizacionGarantiaRepository = autorizacionGarantiaRepository;
	}

}
