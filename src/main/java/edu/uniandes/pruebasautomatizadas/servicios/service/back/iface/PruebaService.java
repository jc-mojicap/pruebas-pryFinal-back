package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Prueba;

import java.util.List;
import java.util.Optional;

public interface PruebaService {

    Optional<Prueba> buscarPorId(Long id);

    List<Prueba> buscarTodas();

    Optional<Prueba> buscarPorNombre(String nombre);

    List<Prueba> buscarPorAplicacion(Aplicacion aplicacion);

    Prueba crearPrueba(Prueba prueba);
}
