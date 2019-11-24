package edu.uniandes.arquitectura.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dedicacion")
public class Dedicacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dedicacion", nullable = false)
	private Long idDedicacion;
	
	@Column(name = "codigo_dedicacion", nullable = false)
	private String codigoDedicacion;
	
	@Column(name = "nombre_dedicacion", nullable = false)
	private String nombreDedicacion;
	
	@Column(name = "numero_horas", nullable = false)
	private Double numeroHoras;
	
	public Dedicacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDedicacion() {
		return idDedicacion;
	}
	public void setIdDedicacion(Long idDedicacion) {
		this.idDedicacion = idDedicacion;
	}
	public String getCodigoDedicacion() {
		return codigoDedicacion;
	}
	public void setCodigoDedicacion(String codigoDedicacion) {
		this.codigoDedicacion = codigoDedicacion;
	}
	public String getNombreDedicacion() {
		return nombreDedicacion;
	}
	public void setNombreDedicacion(String nombreDedicacion) {
		this.nombreDedicacion = nombreDedicacion;
	}
	public Double getNumeroHoras() {
		return numeroHoras;
	}
	public void setNumeroHoras(Double numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDedicacion == null) ? 0 : idDedicacion.hashCode());
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
		Dedicacion other = (Dedicacion) obj;
		if (idDedicacion == null) {
			if (other.idDedicacion != null)
				return false;
		} else if (!idDedicacion.equals(other.idDedicacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dedicacion [" + (idDedicacion != null ? "idDedicacion=" + idDedicacion + ", " : "")
				+ (codigoDedicacion != null ? "codigoDedicacion=" + codigoDedicacion + ", " : "")
				+ (nombreDedicacion != null ? "nombreDedicacion=" + nombreDedicacion + ", " : "")
				+ (numeroHoras != null ? "numeroHoras=" + numeroHoras : "") + "]";
	}
	
}
