package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class EquivalenciaDTO {

	private Long idEquivalencia;
	private String codigoEquivalencia;
	private String nombreEquivalencia;
	
	public EquivalenciaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdEquivalencia() {
		return idEquivalencia;
	}
	public void setIdEquivalencia(Long idEquivalencia) {
		this.idEquivalencia = idEquivalencia;
	}
	public String getCodigoEquivalencia() {
		return codigoEquivalencia;
	}
	public void setCodigoEquivalencia(String codigoEquivalencia) {
		this.codigoEquivalencia = codigoEquivalencia;
	}
	public String getNombreEquivalencia() {
		return nombreEquivalencia;
	}
	public void setNombreEquivalencia(String nombreEquivalencia) {
		this.nombreEquivalencia = nombreEquivalencia;
	}
	
}
