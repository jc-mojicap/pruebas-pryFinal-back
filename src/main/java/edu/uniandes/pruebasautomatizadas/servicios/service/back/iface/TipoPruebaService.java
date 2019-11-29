package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoPrueba;

import java.util.List;
import java.util.Optional;

public interface TipoPruebaService {

    Optional<TipoPrueba> buscarPorId(Long id);

    List<TipoPrueba> buscarTodas();
}
