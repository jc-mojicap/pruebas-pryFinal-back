package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_identificacion")
public class TipoIdentificacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_identificacion", nullable = false)
	private Long idTipoIdentificacion;
	
	@Column(name = "tipo_identificacion")
	private String tipoIdentificacion;
	
	@Column(name = "nombre_tipo_identificacion")
	private String nombreTipoIdentificacion;
	
	public TipoIdentificacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}
	public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNombreTipoIdentificacion() {
		return nombreTipoIdentificacion;
	}
	public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
		this.nombreTipoIdentificacion = nombreTipoIdentificacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoIdentificacion == null) ? 0 : idTipoIdentificacion.hashCode());
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
		TipoIdentificacion other = (TipoIdentificacion) obj;
		if (idTipoIdentificacion == null) {
			if (other.idTipoIdentificacion != null)
				return false;
		} else if (!idTipoIdentificacion.equals(other.idTipoIdentificacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TipoIdentificacion ["
				+ (idTipoIdentificacion != null ? "idTipoIdentificacion=" + idTipoIdentificacion + ", " : "")
				+ (tipoIdentificacion != null ? "tipoIdentificacion=" + tipoIdentificacion + ", " : "")
				+ (nombreTipoIdentificacion != null ? "nombreTipoIdentificacion=" + nombreTipoIdentificacion : "")
				+ "]";
	}
	
	
}
