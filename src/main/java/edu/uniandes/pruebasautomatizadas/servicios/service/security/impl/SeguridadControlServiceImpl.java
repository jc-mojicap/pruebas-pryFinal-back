package edu.uniandes.pruebasautomatizadas.servicios.service.security.impl;

import java.util.Date;
import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.service.security.iface.SeguridadControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface.SeguridadControlRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.SeguridadControl;

@Service
public class SeguridadControlServiceImpl implements SeguridadControlService {

	@Autowired
	private SeguridadControlRepository seguridadControlRepository;
	
	@Override
	public List<SeguridadControl> buscarPorIp(String ip) {
		return seguridadControlRepository.findByIp(ip);
	}

	@Override
	public List<SeguridadControl> buscarPorIpYFecha(String ip, Date fecha) {
		return seguridadControlRepository.findByIpAndFecha(ip, fecha);
	}

	@Override
	public Long contarPorIpYRangoFecha(String ip, Date fechaInicial, Date fechaFinal) {
		return seguridadControlRepository.countByIpAndFechaBetween(ip, fechaInicial, fechaFinal);
	}

	@Override
	public void guardarRegistro(SeguridadControl seguridadControl) {
		seguridadControlRepository.saveAndFlush(seguridadControl);
	}

}