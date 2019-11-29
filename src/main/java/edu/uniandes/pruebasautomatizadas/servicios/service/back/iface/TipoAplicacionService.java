package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoAplicacion;

import java.util.List;
import java.util.Optional;

public interface TipoAplicacionService {

    Optional<TipoAplicacion> buscarPorId(Long id);

    List<TipoAplicacion> buscarTodas();

}
