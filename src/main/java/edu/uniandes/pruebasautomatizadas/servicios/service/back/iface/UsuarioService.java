package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import java.util.List;
import java.util.Optional;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

/**
 * Servicios de negocio para el recurso Usuario
 *
 */
public interface UsuarioService {


    Optional<Usuario> buscarPorId(Integer id);

    List<Usuario> listarPorNombreUsuario(String nombreUsuario);

    Usuario registrarUsuario(Usuario usuarioRegistrar);
    
}
