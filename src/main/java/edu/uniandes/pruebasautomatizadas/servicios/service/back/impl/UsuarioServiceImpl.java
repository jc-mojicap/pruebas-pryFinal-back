package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import java.util.List;
import java.util.Optional;

import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.UsuarioService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.UsuarioRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

/**
 * Implementación de los servicios de negocio para el recurso Usuario.
 * 
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        Validate.notNull(id, "El parámetro id no puede ser nulo");
        Usuario entidad = usuarioRepository.findOne(id);
        return entidad != null ? Optional.of(entidad) : Optional.empty();
    }
    
    @Override
    public List<Usuario> listarPorNombreUsuario(String nombresUsuario) {
        return usuarioRepository.findByNombreUsuario(nombresUsuario);
    }

	@Override
	public Usuario registrarUsuario(Usuario usuarioRegistrar) {
		Validate.notNull(usuarioRegistrar, "El parámetro usuario no puede ser nulo");
		Validate.notNull(usuarioRegistrar.getContrasena(), "El parámetro  contraseña no puede ser nulo");
		Validate.notNull(usuarioRegistrar.getNombreUsuario(), "El parámetro nombre usuario no puede ser nulo");
		usuarioRepository.save(usuarioRegistrar);
		
		return usuarioRegistrar;
	}

}
