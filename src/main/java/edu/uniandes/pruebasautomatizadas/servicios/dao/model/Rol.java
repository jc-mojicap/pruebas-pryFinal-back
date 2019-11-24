package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
	
	@Basic(optional = false)
    @Column(name = "nombre_rol", nullable = false, length = 50)
	private String nombreRol;
	
	@Basic(optional = false)
    @Column(name = "codigo_rol", nullable = false, length = 50)
	private String codigoRol;
	
	@Basic(optional = false)
    @Column(nullable = false)
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
		Rol other = (Rol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rol [" + (id != null ? "id=" + id + ", " : "")
				+ (nombreRol != null ? "nombreRol=" + nombreRol + ", " : "")
				+ (codigoRol != null ? "codigoRol=" + codigoRol + ", " : "")
				+ (estado != null ? "estado=" + estado : "") + "]";
	}
}
