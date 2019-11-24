package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

import java.util.Date;

public class PersonaDTO {
	
	private Long idPersona;
	private String identificacion;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private String direccionElectronica;
	private String direccionContacto;
	private String telefonoContacto;
	private String telefonoCelular;
	private String estado;
	private Date fechaNacimiento;
	

	public PersonaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getDireccionElectronica() {
		return direccionElectronica;
	}
	public void setDireccionElectronica(String direccionElectronica) {
		this.direccionElectronica = direccionElectronica;
	}
	public String getDireccionContacto() {
		return direccionContacto;
	}
	public void setDireccionContacto(String direccionContacto) {
		this.direccionContacto = direccionContacto;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
