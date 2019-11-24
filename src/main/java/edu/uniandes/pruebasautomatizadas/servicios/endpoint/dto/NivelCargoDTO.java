package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

public class NivelCargoDTO {

	private Long idNivelCargo;
	private String codigoNivelCargo;
	private String nombreNivelCargo;
	private Integer nivelJerarquico;
	
	
	public NivelCargoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdNivelCargo() {
		return idNivelCargo;
	}
	public void setIdNivelCargo(Long idNivelCargo) {
		this.idNivelCargo = idNivelCargo;
	}
	public String getCodigoNivelCargo() {
		return codigoNivelCargo;
	}
	public void setCodigoNivelCargo(String codigoNivelCargo) {
		this.codigoNivelCargo = codigoNivelCargo;
	}
	public String getNombreNivelCargo() {
		return nombreNivelCargo;
	}
	public void setNombreNivelCargo(String nombreNivelCargo) {
		this.nombreNivelCargo = nombreNivelCargo;
	}
	public Integer getNivelJerarquico() {
		return nivelJerarquico;
	}
	public void setNivelJerarquico(Integer nivelJerarquico) {
		this.nivelJerarquico = nivelJerarquico;
	}
	
	
	
}
