package edu.uniandes.arquitectura.servicios.endpoint.dto;

import java.util.Date;

public class DetalleAutorizacionGarantiaDTO {

	private Long idDetalleAutorizacion;
	private AutorizacionGarantiaDTO autorizacionGarantia;
	private Date fechaRegistro;
	private String estado;
	private String especificacionReparacion;
	private Integer cantidadAutorizada;
	private ReferenciaDTO referencia;
	
	public DetalleAutorizacionGarantiaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDetalleAutorizacion() {
		return idDetalleAutorizacion;
	}
	public void setIdDetalleAutorizacion(Long idDetalleAutorizacion) {
		this.idDetalleAutorizacion = idDetalleAutorizacion;
	}
	public AutorizacionGarantiaDTO getAutorizacionGarantia() {
		return autorizacionGarantia;
	}
	public void setAutorizacionGarantia(AutorizacionGarantiaDTO autorizacionGarantia) {
		this.autorizacionGarantia = autorizacionGarantia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEspecificacionReparacion() {
		return especificacionReparacion;
	}
	public void setEspecificacionReparacion(String especificacionReparacion) {
		this.especificacionReparacion = especificacionReparacion;
	}
	public Integer getCantidadAutorizada() {
		return cantidadAutorizada;
	}
	public void setCantidadAutorizada(Integer cantidadAutorizada) {
		this.cantidadAutorizada = cantidadAutorizada;
	}
	public ReferenciaDTO getReferencia() {
		return referencia;
	}
	public void setReferencia(ReferenciaDTO referencia) {
		this.referencia = referencia;
	}
	
}
