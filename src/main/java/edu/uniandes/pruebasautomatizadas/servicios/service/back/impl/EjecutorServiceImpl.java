package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.EjecutorRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Ejecutor;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.EjecutorService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjecutorServiceImpl implements EjecutorService {

    @Autowired
    private EjecutorRepository ejecutorRepository;


    @Override
    public Optional<Ejecutor> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        Ejecutor ejecutor = ejecutorRepository.findOne(id);
        return ejecutor != null ? Optional.of(ejecutor) : Optional.empty();
    }

    @Override
    public List<Ejecutor> buscarTodas() {
        return ejecutorRepository.findAll();
    }
}
