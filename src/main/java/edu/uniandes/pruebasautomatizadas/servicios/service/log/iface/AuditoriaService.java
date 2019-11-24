package edu.uniandes.pruebasautomatizadas.servicios.service.log.iface;

import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Auditoria;

public interface AuditoriaService {

	List<Auditoria> findByTablaModificada(String tablaModificada);
	
	Auditoria guardarAuditoria(Auditoria auditoria);
	
}
