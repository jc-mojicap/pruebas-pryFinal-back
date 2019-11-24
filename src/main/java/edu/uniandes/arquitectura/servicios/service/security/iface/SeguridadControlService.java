package edu.uniandes.arquitectura.servicios.service.security.iface;

import java.util.Date;
import java.util.List;

import edu.uniandes.arquitectura.servicios.dao.model.SeguridadControl;

public interface SeguridadControlService {

	List<SeguridadControl> buscarPorIp(String ip);
	
	List<SeguridadControl> buscarPorIpYFecha(String ip, Date fecha);
	
	Long contarPorIpYRangoFecha(String ip, Date fechaInicial, Date fechaFinal);
	
	void guardarRegistro(SeguridadControl seguridadControl);
	
}
