package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Ejecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjecutorRepository extends JpaRepository<Ejecutor, Long> {
}
