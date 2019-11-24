package edu.uniandes.arquitectura.servicios.service.log.iface;

import java.util.List;

import edu.uniandes.arquitectura.servicios.dao.model.Auditoria;

public interface AuditoriaService {

	List<Auditoria> findByTablaModificada(String tablaModificada);
	
	Auditoria guardarAuditoria(Auditoria auditoria);
	
}
