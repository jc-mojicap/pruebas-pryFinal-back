package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.SeguridadControl;

public interface SeguridadControlRepository extends JpaRepository<SeguridadControl, Integer>{

	List<SeguridadControl> findByIp(String ip);

	List<SeguridadControl> findByIpAndFecha(String ip, Date fecha);

	Long countByIpAndFechaBetween(String ip, Date fechaInicial, Date fechaFinal);
	
}
