package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoAplicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAplicacionRepository extends JpaRepository<TipoAplicacion, Long> {

}
