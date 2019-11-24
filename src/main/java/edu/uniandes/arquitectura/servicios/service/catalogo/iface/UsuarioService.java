package edu.uniandes.arquitectura.servicios.service.catalogo.iface;

import java.util.List;
import java.util.Optional;

import edu.uniandes.arquitectura.servicios.dao.model.Usuario;

/**
 * Servicios de negocio para el recurso Usuario
 *
 */
public interface UsuarioService {

    /**
     * Retorna un Usuario.
     * 
     * @param id
     *            identificador de la entidad.
     * @return El usuario relacionado.
     */
    Optional<Usuario> buscarPorId(Integer id);

    /**
     * Retorna un Usuario.
     * 
     * @param codigo
     *            Código del usuario.
     * @return El usuario relacionado.
     */
    Optional<Usuario> buscarPorCodigoUsuario(String codigo);

    /**
     * Retorna una lista de usuarios dependiendo de su nombre de usuario.
     * 
     * @param nombresUsuario
     *            Nombre de usuario a buscar.
     * @return Lista con los usuarios asociados.
     */
    List<Usuario> listarPorNombreUsuario(String nombreUsuario);
    
    /**
     * Registra usuario y retorna el objeto
     * @param usuarioRegistrar
     * @return Objeto usuario
     */
    Usuario registrarUsuario(Usuario usuarioRegistrar);
    
}
