package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class ClienteDTO{

	private Long idCliente;
	private PersonaDTO persona;
	
	
	public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	
}
