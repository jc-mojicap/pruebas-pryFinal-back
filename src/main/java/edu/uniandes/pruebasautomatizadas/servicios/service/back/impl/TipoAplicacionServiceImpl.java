package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.TipoAplicacionRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoAplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.TipoAplicacionService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAplicacionServiceImpl implements TipoAplicacionService {

    @Autowired
    private TipoAplicacionRepository tipoAplicacionRepository;

    @Override
    public Optional<TipoAplicacion> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        TipoAplicacion tipoAplicacion = tipoAplicacionRepository.findOne(id);
        return tipoAplicacion != null ? Optional.of(tipoAplicacion) : Optional.empty();
    }

    @Override
    public List<TipoAplicacion> buscarTodas() {
        return tipoAplicacionRepository.findAll();
    }
}
