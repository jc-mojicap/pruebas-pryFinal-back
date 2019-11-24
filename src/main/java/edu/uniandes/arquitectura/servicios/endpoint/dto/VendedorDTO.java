package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class VendedorDTO{

	private Long idVendedor;
	private PersonaDTO persona;
	
	
	public VendedorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	
}
