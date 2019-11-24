package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

public class MecanicoDTO {

	private PersonaDTO persona;
	private Long idMecanico;
	private String especialidad;
	
	public MecanicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	public Long getIdMecanico() {
		return idMecanico;
	}
	public void setIdMecanico(Long idMecanico) {
		this.idMecanico = idMecanico;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
