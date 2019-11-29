package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

/**
 * CRUDRepository de la entidad Usuario.
 * 
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    /**
     * findById
     * @param id (identificador del usuario)
     * @return Usuario asociado
     */
    Usuario findById(Integer id);

    /**
     * findByNombreUsuario.
     * 
     * @param nombresUsuario
     *            Nombre de usuario a ser buscado.
     * @return Lista con los usuarios.
     */
    List<Usuario> findByNombreUsuario(String nombresUsuario);
    
}
