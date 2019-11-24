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
@Table(name="vendedor")
public class Vendedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
	
	@JoinColumn(name = "persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Persona persona;
	
	@Column(name="numero_empleado")
	private String numeroEmpleado;
	
	@Column(name="cargo")
	private String cargo;
	
	@Column(name="concesionario")
	private String concesionario;

	
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(String numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getConcesionario() {
		return concesionario;
	}

	public void setConcesionario(String concesionario) {
		this.concesionario = concesionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numeroEmpleado == null) ? 0 : numeroEmpleado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (numeroEmpleado == null) {
			if (other.numeroEmpleado != null)
				return false;
		} else if (!numeroEmpleado.equals(other.numeroEmpleado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendedor [" + (numeroEmpleado != null ? "numeroEmpleado=" + numeroEmpleado + ", " : "")
				+ (cargo != null ? "cargo=" + cargo + ", " : "")
				+ (concesionario != null ? "concesionario=" + concesionario : "") + "]";
	}
	
}
