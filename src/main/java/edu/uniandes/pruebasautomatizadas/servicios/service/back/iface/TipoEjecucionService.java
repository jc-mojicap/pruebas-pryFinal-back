package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoEjecucion;

import java.util.List;
import java.util.Optional;

public interface TipoEjecucionService {

    Optional<TipoEjecucion> buscarPorId(Long id);

    List<TipoEjecucion> buscarTodas();
}
