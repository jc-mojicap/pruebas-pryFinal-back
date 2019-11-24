package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class DedicacionDTO {

	private Long idDedicacion;
	private String codigoDedicacion;
	private String nombreDedicacion;
	private Double numeroHoras;
	
	public DedicacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDedicacion() {
		return idDedicacion;
	}
	public void setIdDedicacion(Long idDedicacion) {
		this.idDedicacion = idDedicacion;
	}
	public String getCodigoDedicacion() {
		return codigoDedicacion;
	}
	public void setCodigoDedicacion(String codigoDedicacion) {
		this.codigoDedicacion = codigoDedicacion;
	}
	public String getNombreDedicacion() {
		return nombreDedicacion;
	}
	public void setNombreDedicacion(String nombreDedicacion) {
		this.nombreDedicacion = nombreDedicacion;
	}
	public Double getNumeroHoras() {
		return numeroHoras;
	}
	public void setNumeroHoras(Double numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	
	
}
