package edu.uniandes.arquitectura.servicios.service.log.iface;

import java.util.List;

import edu.uniandes.arquitectura.servicios.dao.model.Trazabilidad;

public interface TrazabilidadService {

	List<Trazabilidad> findByNivelTraza(String nivelTraza);
	
	Trazabilidad guardarTraza(Trazabilidad trazabilidad);
	
}
