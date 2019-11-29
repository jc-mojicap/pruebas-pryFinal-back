package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    Prueba findByNombre(String nombre);

    List<Prueba> findAllByAplicacion(Aplicacion aplicacion);
}
