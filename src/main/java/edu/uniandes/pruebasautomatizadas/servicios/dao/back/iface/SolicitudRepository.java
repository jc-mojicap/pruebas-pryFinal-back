package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Solicitud;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    List<Solicitud> findAllByCreadoPor(Usuario usuario);
}
