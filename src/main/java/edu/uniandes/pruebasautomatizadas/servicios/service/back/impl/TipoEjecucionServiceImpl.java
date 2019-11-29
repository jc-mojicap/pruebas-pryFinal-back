package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.TipoEjecucionRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoEjecucion;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.TipoEjecucionService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEjecucionServiceImpl implements TipoEjecucionService {

    @Autowired
    private TipoEjecucionRepository tipoEjecucionRepository;

    @Override
    public Optional<TipoEjecucion> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        TipoEjecucion tipoEjecucion = tipoEjecucionRepository.findOne(id);
        return tipoEjecucion != null ? Optional.of(tipoEjecucion) : Optional.empty();
    }

    @Override
    public List<TipoEjecucion> buscarTodas() {
        return tipoEjecucionRepository.findAll();
    }
}
