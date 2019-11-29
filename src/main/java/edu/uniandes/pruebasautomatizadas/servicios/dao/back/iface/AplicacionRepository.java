package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {

    List<Aplicacion> findAllByCreadoPor(Usuario usuario);
}
