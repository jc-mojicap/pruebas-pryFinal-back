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
@Table(name="cargo")
public class Cargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo", nullable = false)
	private Long idCargo;
	
	@Column(name = "codigo_cargo", nullable = false)
	private String codigoCargo;
	
	@Column(name = "nombre_cargo", nullable = false)
	private String nombreCargo;
	
	@JoinColumn(name = "nivelCargo", referencedColumnName = "id_nivel_cargo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private NivelCargo nivelCargo;
	
	public Cargo() {
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
	public NivelCargo getNivelCargo() {
		return nivelCargo;
	}
	public void setNivelCargo(NivelCargo nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCargo == null) ? 0 : idCargo.hashCode());
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
		Cargo other = (Cargo) obj;
		if (idCargo == null) {
			if (other.idCargo != null)
				return false;
		} else if (!idCargo.equals(other.idCargo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cargo [" + (idCargo != null ? "idCargo=" + idCargo + ", " : "")
				+ (codigoCargo != null ? "codigoCargo=" + codigoCargo + ", " : "")
				+ (nombreCargo != null ? "nombreCargo=" + nombreCargo + ", " : "")
				+ (nivelCargo != null ? "nivelCargo=" + nivelCargo : "") + "]";
	}

}
