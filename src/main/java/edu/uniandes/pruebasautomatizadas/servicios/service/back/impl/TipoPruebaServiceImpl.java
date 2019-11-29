package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.TipoPruebaRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoPrueba;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.TipoPruebaService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPruebaServiceImpl implements TipoPruebaService {

    @Autowired
    private TipoPruebaRepository tipoPruebaRepository;

    @Override
    public Optional<TipoPrueba> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        TipoPrueba tipoEjecucion = tipoPruebaRepository.findOne(id);
        return tipoEjecucion != null ? Optional.of(tipoEjecucion) : Optional.empty();
    }

    @Override
    public List<TipoPrueba> buscarTodas() {
        return tipoPruebaRepository.findAll();
    }
}
