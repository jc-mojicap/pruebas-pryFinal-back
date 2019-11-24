package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equivalencia")
public class Equivalencia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equivalencia", nullable = false)
	private Long idEquivalencia;
	
	@Column(name = "codigo_equivalencia", nullable = false)
	private String codigoEquivalencia;
	
	@Column(name = "nombre_equivalencia", nullable = false)
	private String nombreEquivalencia;
	
	public Equivalencia() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEquivalencia == null) ? 0 : idEquivalencia.hashCode());
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
		Equivalencia other = (Equivalencia) obj;
		if (idEquivalencia == null) {
			if (other.idEquivalencia != null)
				return false;
		} else if (!idEquivalencia.equals(other.idEquivalencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equivalencia [" + (idEquivalencia != null ? "idEquivalencia=" + idEquivalencia + ", " : "")
				+ (codigoEquivalencia != null ? "codigoEquivalencia=" + codigoEquivalencia + ", " : "")
				+ (nombreEquivalencia != null ? "nombreEquivalencia=" + nombreEquivalencia : "") + "]";
	}
	
}
