package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class CargoDTO {

	private Long idCargo;
	private String codigoCargo;
	private String nombreCargo;
	private NivelCargoDTO nivelCargo;
	
	public CargoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	public String getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public NivelCargoDTO getNivelCargo() {
		return nivelCargo;
	}
	public void setNivelCargo(NivelCargoDTO nivelCargo) {
		this.nivelCargo = nivelCargo;
	}
	
	
}
