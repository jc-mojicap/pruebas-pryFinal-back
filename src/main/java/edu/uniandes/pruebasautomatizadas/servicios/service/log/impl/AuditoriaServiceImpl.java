package edu.uniandes.pruebasautomatizadas.servicios.service.log.impl;

import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.service.log.iface.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface.AuditoriaRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Auditoria;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

	@Autowired
	private AuditoriaRepository auditoriaRepository;
	
	@Override
	public List<Auditoria> findByTablaModificada(String tablaModificada) {
		return auditoriaRepository.findByTablaModificada(tablaModificada);
	}

	@Override
	public Auditoria guardarAuditoria(Auditoria auditoria) {
		return auditoriaRepository.saveAndFlush(auditoria);
	}

}
