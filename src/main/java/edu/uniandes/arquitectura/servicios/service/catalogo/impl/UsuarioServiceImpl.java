package edu.uniandes.arquitectura.servicios.service.catalogo.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.UsuarioRepository;
import edu.uniandes.arquitectura.servicios.dao.model.Usuario;
import edu.uniandes.arquitectura.servicios.service.catalogo.iface.UsuarioService;

/**
 * Implementación de los servicios de negocio para el recurso Usuario.
 * 
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    /**
     * UsuarioRepository.
     */
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        Validate.notNull(id, "El parámetro id no puede ser nulo");
        Usuario entidad = usuarioRepository.findOne(id);
        return entidad != null ? Optional.of(entidad) : Optional.empty();
    }

    @Override
    public Optional<Usuario> buscarPorCodigoUsuario(String codigo) {
        Validate.notNull(codigo, "El parámetro codigo no puede ser nulo");
        Usuario entidad = usuarioRepository.findByCodigoUsuario(codigo);
        return entidad != null ? Optional.of(entidad) : Optional.empty();
    }
    
    @Override
    public List<Usuario> listarPorNombreUsuario(String nombresUsuario) {
        return usuarioRepository.findByNombreUsuario(nombresUsuario);
    }

	@Override
	public Usuario registrarUsuario(Usuario usuarioRegistrar) {
		// TODO Auto-generated method stub
		Validate.notNull(usuarioRegistrar, "El parámetro usuario no puede ser nulo");
		Validate.notNull(usuarioRegistrar.getCodigoUsuario(), "El parámetro código usuario no puede ser nulo");
		Validate.notNull(usuarioRegistrar.getContrasena(), "El parámetro  contraseña no puede ser nulo");
		Validate.notNull(usuarioRegistrar.getNombreUsuario(), "El parámetro nombre usuario no puede ser nulo");
		
		usuarioRegistrar.setEstado("A");
		usuarioRegistrar.setFechaModifica(new Date());
		usuarioRepository.save(usuarioRegistrar);
		
		return usuarioRegistrar;
	}

}
