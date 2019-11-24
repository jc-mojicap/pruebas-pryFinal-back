package edu.uniandes.arquitectura.servicios.endpoint.dto;

import java.util.Date;

public class GarantiaDTO {

	private Long idGarantia;
	private String codigoGarantia;
	private String descripcionGarantia;
	private String motivoGarantia;
	private ClienteDTO cliente;
	private Date fechaSolicitud;
	private Date fechaRegistro;
	private Date fechaActualizacion;
	private String estado;
	private String tipoGarantia;
	private EmpleadoDTO responsableGarantia;
	private EmpleadoDTO responsableAutorizacion;
	private String observaciones;
	
	public GarantiaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdGarantia() {
		return idGarantia;
	}
	public void setIdGarantia(Long idGarantia) {
		this.idGarantia = idGarantia;
	}
	public String getCodigoGarantia() {
		return codigoGarantia;
	}
	public void setCodigoGarantia(String codigoGarantia) {
		this.codigoGarantia = codigoGarantia;
	}
	public String getDescripcionGarantia() {
		return descripcionGarantia;
	}
	public void setDescripcionGarantia(String descripcionGarantia) {
		this.descripcionGarantia = descripcionGarantia;
	}
	public String getMotivoGarantia() {
		return motivoGarantia;
	}
	public void setMotivoGarantia(String motivoGarantia) {
		this.motivoGarantia = motivoGarantia;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	public String getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public EmpleadoDTO getResponsableGarantia() {
		return responsableGarantia;
	}
	public void setResponsableGarantia(EmpleadoDTO responsableGarantia) {
		this.responsableGarantia = responsableGarantia;
	}
	public EmpleadoDTO getResponsableAutorizacion() {
		return responsableAutorizacion;
	}
	public void setResponsableAutorizacion(EmpleadoDTO responsableAutorizacion) {
		this.responsableAutorizacion = responsableAutorizacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
