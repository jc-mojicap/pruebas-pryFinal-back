package edu.uniandes.arquitectura.servicios.endpoint.dto;

import java.util.Date;

public class AutorizacionGarantiaDTO {

	private Long idAutorizacion;
	private String codigoAutorizacion;
	private String especificacionAutorizacion;
	private Date fechaAutorizacion;
	private Date fechaActualizacion;
	private String estado;
	private EmpleadoDTO empleado;
	private GarantiaDTO garantia;
	
	public AutorizacionGarantiaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Long idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public String getEspecificacionAutorizacion() {
		return especificacionAutorizacion;
	}
	public void setEspecificacionAutorizacion(String especificacionAutorizacion) {
		this.especificacionAutorizacion = especificacionAutorizacion;
	}
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public EmpleadoDTO getEmpleado() {
		return empleado;
	}
	public void setEmpleado(EmpleadoDTO mecanico) {
		this.empleado = mecanico;
	}
	public GarantiaDTO getGarantia() {
		return garantia;
	}
	public void setGarantia(GarantiaDTO garantia) {
		this.garantia = garantia;
	}
	
	
}
