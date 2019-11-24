package edu.uniandes.arquitectura.servicios.endpoint.catalogo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.uniandes.arquitectura.servicios.dao.model.Usuario;
import edu.uniandes.arquitectura.servicios.endpoint.BaseRest;
import edu.uniandes.arquitectura.servicios.endpoint.dto.UsuarioDTO;
import edu.uniandes.arquitectura.servicios.endpoint.mapper.UsuarioMapper;
import edu.uniandes.arquitectura.servicios.service.catalogo.iface.UsuarioService;

@RestController
public class UsuarioRestEndpoint extends BaseRest {

    /**
     * Nombre del módulo utilizado como prefijo de la URL.
     */
    private static final String MODULO = "catalogo";

    /**
     * Nombre de la entidad.
     */
    private static final String ENTIDAD = "usuario";

    /**
     * SerieService.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Permite obtener un Usuario por el id. <br>
     * Peticion: <br>
     * - URL: /catalogo/usuarioid <br>
     * - Metodo: GET <br>
     * - Parametros: <br>
     * -- id: Id numerico del usuario a obtener. <br>
     * Autenticacion: No requerida. <br>
     * Respuesta: <br>
     * - Si el usuario existe: <br>
     * -- Cabecera HTTP con status code 200 <br>
     * -- Cuerpo: Usuario. <br>
     * - Si el usuario no existe: <br>
     * -- Cabecera HTTP con status code 404 (not found).
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "id", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> obtenerPorId(@RequestParam(name = "id") Integer id) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        if (usuario.isPresent()) {
//            return ResponseEntity.ok(UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario.get()));
            return null;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Permite obtener un Usuario por el codigo de usuario. <br>
     * Peticion: <br>
     * - URL: /catalogo/usuariocod <br>
     * - Metodo: GET <br>
     * - Parametros: <br>
     * -- codigo: código del usuario a obtener. <br>
     * Autenticacion: No requerida. <br>
     * Respuesta: <br>
     * - Si el usuario existe: <br>
     * -- Cabecera HTTP con status code 200 <br>
     * -- Cuerpo: Usuario. <br>
     * - Si el usuario no existe: <br>
     * -- Cabecera HTTP con status code 404 (not found).
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "cod", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> obtenerPorCodigo(@RequestParam(name = "codigo") String codigo) {
        Optional<Usuario> usuario = usuarioService.buscarPorCodigoUsuario(codigo);
        if (usuario.isPresent()) {
//            return ResponseEntity.ok(UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario.get()));
            return null;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * * Permite obtener un listado de usuarios por nombre de usuario. <br>
     * Peticion: <br>
     * - URL: /catalogo/usuarios/nombreusuario<br>
     * - Metodo: GET <br>
     * - Parametros: <br>
     * -- nombreusuario: El nombre de usuario sobre el cual se va a realizar la
     * busqueda. <br>
     * 
     * @param nombreUsuario
     * @return
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "s/nombreusuario", method = RequestMethod.GET)
    public List<UsuarioDTO> listarPorNombreUsuario(@RequestParam(name = "username") String nombreUsuario) {
        List<Usuario> usuarios = usuarioService.listarPorNombreUsuario(nombreUsuario);
//        return UsuarioMapper.INSTANCE.usuariosToUsuariosDto(usuarios);
        return null;
    }
    
}
