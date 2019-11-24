package edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

/**
 * CRUDRepository de la entidad Usuario.
 * 
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    /**
     * findByCodigoUsuario.
     * 
     * @param codigoUsuario
     *            Codigo del usuario.
     * @return El usuario asociado.
     */
    Usuario findByCodigoUsuario(String codigoUsuario);

    /**
     * findById
     * @param id (identificador del usuario)
     * @return Usuario asociado
     */
    Usuario findById(Integer id);
    
    /**
     * findByCodigoUsuarioAndContrasena
     * @param codigoUsuario
     * @param contrasena
     * @return usuario asociado
     */
    Usuario findByCodigoUsuarioAndContrasena(String codigoUsuario, String contrasena); 
    
    /**
     * findByNombreUsuario.
     * 
     * @param nombresUsuario
     *            Nombre de usuario a ser buscado.
     * @return Lista con los usuarios.
     */
    List<Usuario> findByNombreUsuario(String nombresUsuario);
    
}
