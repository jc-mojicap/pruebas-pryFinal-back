package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
	
	@JoinColumn(name = "persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Persona persona;

	@JoinColumn(name = "tipoEmpleado", referencedColumnName = "id_tipo_empleado", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TipoEmpleado tipoEmpleado;
	
	@JoinColumn(name = "equivalencia", referencedColumnName = "id_equivalencia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Equivalencia equivalencia;
	
	@JoinColumn(name = "dedicacion", referencedColumnName = "id_dedicacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Dedicacion dedicacion;
	
	@JoinColumn(name = "cargo", referencedColumnName = "id_cargo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Cargo cargo;
	
	@Column(name = "numero_contrato", nullable = false)
	private Long numeroContrato;
	
	@Column(name = "salario", nullable = false)
	private Double salario;
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Equivalencia getEquivalencia() {
		return equivalencia;
	}

	public void setEquivalencia(Equivalencia equivalencia) {
		this.equivalencia = equivalencia;
	}

	public Dedicacion getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(Dedicacion dedicacion) {
		this.dedicacion = dedicacion;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [" + (id != null ? "id=" + id + ", " : "")
				+ (persona != null ? "persona=" + persona + ", " : "")
				+ (tipoEmpleado != null ? "tipoEmpleado=" + tipoEmpleado + ", " : "")
				+ (equivalencia != null ? "equivalencia=" + equivalencia + ", " : "")
				+ (dedicacion != null ? "dedicacion=" + dedicacion + ", " : "")
				+ (cargo != null ? "cargo=" + cargo + ", " : "")
				+ (numeroContrato != null ? "numeroContrato=" + numeroContrato + ", " : "")
				+ (salario != null ? "salario=" + salario : "") + "]";
	}
	
}
