package edu.uniandes.pruebasautomatizadas.servicios.service.log.iface;

import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Trazabilidad;

public interface TrazabilidadService {

	List<Trazabilidad> findByNivelTraza(String nivelTraza);
	
	Trazabilidad guardarTraza(Trazabilidad trazabilidad);
	
}
