package edu.uniandes.pruebasautomatizadas.servicios.service.log.impl;

import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.service.log.iface.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface.TrazabilidadRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Trazabilidad;

@Service
public class TrazabilidadServiceImpl implements TrazabilidadService {

	@Autowired
	private TrazabilidadRepository trazabilidadRepository;
	
	@Override
	public List<Trazabilidad> findByNivelTraza(String nivelTraza) {
		return trazabilidadRepository.findByNivelTraza(nivelTraza);
	}

	@Override
	public Trazabilidad guardarTraza(Trazabilidad trazabilidad) {
		return trazabilidadRepository.saveAndFlush(trazabilidad);
	}

}
