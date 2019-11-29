package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoEjecucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEjecucionRepository extends JpaRepository<TipoEjecucion, Long> {
}
