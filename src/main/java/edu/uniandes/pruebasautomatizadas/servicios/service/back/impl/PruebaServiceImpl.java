package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.PruebaRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Prueba;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.PruebaService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    private PruebaRepository pruebaRepository;

    @Override
    public Optional<Prueba> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        Prueba prueba = pruebaRepository.findOne(id);
        return prueba != null ? Optional.of(prueba) : Optional.empty();
    }

    @Override
    public List<Prueba> buscarTodas() {
        return pruebaRepository.findAll();
    }

    @Override
    public Optional<Prueba> buscarPorNombre(String nombre) {
        Prueba prueba = pruebaRepository.findByNombre(nombre);
        return prueba != null ? Optional.of(prueba) : Optional.empty();
    }

    @Override
    public List<Prueba> buscarPorAplicacion(Aplicacion aplicacion) {
        return pruebaRepository.findAllByAplicacion(aplicacion);
    }

    @Override
    public Prueba crearPrueba(Prueba prueba) {
        return pruebaRepository.save(prueba);
    }
}
