package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Ejecutor;

import java.util.List;
import java.util.Optional;

public interface EjecutorService {

    Optional<Ejecutor> buscarPorId(Long id);

    List<Ejecutor> buscarTodas();
}
