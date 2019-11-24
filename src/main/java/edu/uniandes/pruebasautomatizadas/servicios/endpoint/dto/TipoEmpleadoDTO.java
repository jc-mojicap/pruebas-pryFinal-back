package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

import java.io.Serializable;

public class TipoEmpleadoDTO implements Serializable{

	private Long idTipoEmpleado;
	private String codigoTipoEmpleado;
	private String nombreTipoEmpleado;
	
	
	public TipoEmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdTipoEmpleado() {
		return idTipoEmpleado;
	}
	public void setIdTipoEmpleado(Long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}
	public String getCodigoTipoEmpleado() {
		return codigoTipoEmpleado;
	}
	public void setCodigoTipoEmpleado(String codigoTipoEmpleado) {
		this.codigoTipoEmpleado = codigoTipoEmpleado;
	}
	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}
	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}
	
	
}
