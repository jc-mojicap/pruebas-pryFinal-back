package edu.uniandes.arquitectura.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nivel_cargo")
public class NivelCargo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_cargo", nullable = false)
	private Long idNivelCargo;
	
	@Column(name = "codigo_nivel_cargo", nullable = false)
	private String codigoNivelCargo;
	
	@Column(name = "nombre_nivel_cargo", nullable = false)
	private String nombreNivelCargo;
	
	@Column(name = "nivel_jerarquico", nullable = false)
	private Integer nivelJerarquico;
	
	
	public NivelCargo() {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNivelCargo == null) ? 0 : idNivelCargo.hashCode());
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
		NivelCargo other = (NivelCargo) obj;
		if (idNivelCargo == null) {
			if (other.idNivelCargo != null)
				return false;
		} else if (!idNivelCargo.equals(other.idNivelCargo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NivelCargo [" + (idNivelCargo != null ? "idNivelCargo=" + idNivelCargo + ", " : "")
				+ (codigoNivelCargo != null ? "codigoNivelCargo=" + codigoNivelCargo + ", " : "")
				+ (nombreNivelCargo != null ? "nombreNivelCargo=" + nombreNivelCargo + ", " : "")
				+ (nivelJerarquico != null ? "nivelJerarquico=" + nivelJerarquico : "") + "]";
	}
	
}
