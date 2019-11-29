package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Herramienta;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {

    Herramienta findByNombre(String nombre);

    List<Herramienta> findAllByCreadoPor(Usuario usuario);
}
