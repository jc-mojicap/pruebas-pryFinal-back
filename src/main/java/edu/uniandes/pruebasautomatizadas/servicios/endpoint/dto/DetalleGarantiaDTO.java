package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

import java.util.Date;

public class DetalleGarantiaDTO {

	private Long idDetalleGarantia;
	private GarantiaDTO garantia;
	private Date fechaRegistro;
	private String estado;
	private String especificacionDetalle;
	private Integer cantidadSolicitada;
	private ReferenciaDTO referencia;
	
	public DetalleGarantiaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDetalleGarantia() {
		return idDetalleGarantia;
	}
	public void setIdDetalleGarantia(Long idDetalleGarantia) {
		this.idDetalleGarantia = idDetalleGarantia;
	}
	public GarantiaDTO getGarantia() {
		return garantia;
	}
	public void setGarantia(GarantiaDTO garantia) {
		this.garantia = garantia;
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
	public String getEspecificacionDetalle() {
		return especificacionDetalle;
	}
	public void setEspecificacionDetalle(String especificacionDetalle) {
		this.especificacionDetalle = especificacionDetalle;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public ReferenciaDTO getReferencia() {
		return referencia;
	}
	public void setReferencia(ReferenciaDTO referencia) {
		this.referencia = referencia;
	}
	
	
}
