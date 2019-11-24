package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class EmpleadoDTO{

	private PersonaDTO persona;
	private Long id;
	private TipoEmpleadoDTO tipoEmpleado;
	private EquivalenciaDTO equivalencia;
	private DedicacionDTO dedicacion;
	private CargoDTO cargo;
	private Long numeroContrato;
	private Double salario;
	
	public EmpleadoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoEmpleadoDTO getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(TipoEmpleadoDTO tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public EquivalenciaDTO getEquivalencia() {
		return equivalencia;
	}
	public void setEquivalencia(EquivalenciaDTO equivalencia) {
		this.equivalencia = equivalencia;
	}
	public DedicacionDTO getDedicacion() {
		return dedicacion;
	}
	public void setDedicacion(DedicacionDTO dedicacion) {
		this.dedicacion = dedicacion;
	}
	public CargoDTO getCargo() {
		return cargo;
	}
	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}
	public Long getNumeroContrato() {
		return numeroContrato;
	}
	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public PersonaDTO getPersona() {
		return persona;
	}
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	
}
