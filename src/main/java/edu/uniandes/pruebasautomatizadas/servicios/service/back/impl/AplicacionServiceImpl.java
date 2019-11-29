package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.AplicacionRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.AplicacionService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AplicacionServiceImpl implements AplicacionService {

    @Autowired
    private AplicacionRepository aplicacionRepository;

    @Override
    public Optional<Aplicacion> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        Aplicacion aplicacion = aplicacionRepository.findOne(id);
        return aplicacion != null ? Optional.of(aplicacion) : Optional.empty();
    }

    @Override
    public List<Aplicacion> buscarTodas() {
        return aplicacionRepository.findAll();
    }

    @Override
    public List<Aplicacion> buscarPorUsuario(Usuario usuario) {
        return aplicacionRepository.findAllByCreadoPor(usuario);
    }
}
