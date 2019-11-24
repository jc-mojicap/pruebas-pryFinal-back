package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_empleado")
public class TipoEmpleado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_empleado", nullable = false)
	private Long idTipoEmpleado;
	
	@Column(name = "codigo_tipo_empleado", nullable = false)
	private String codigoTipoEmpleado;
	
	@Column(name = "nombre_tipo_empleado", nullable = false)
	private String nombreTipoEmpleado;
	
	
	public TipoEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdTipoEmpleado() {
		return idTipoEmpleado;
	}
	public void setIdTipoEmpleado(Long idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}
	public String getCodigoTipoEmpleado() {
		return codigoTipoEmpleado;
	}
	public void setCodigoTipoEmpleado(String codigoTipoEmpleado) {
		this.codigoTipoEmpleado = codigoTipoEmpleado;
	}
	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}
	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoEmpleado == null) ? 0 : idTipoEmpleado.hashCode());
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
		TipoEmpleado other = (TipoEmpleado) obj;
		if (idTipoEmpleado == null) {
			if (other.idTipoEmpleado != null)
				return false;
		} else if (!idTipoEmpleado.equals(other.idTipoEmpleado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoEmpleado [" + (idTipoEmpleado != null ? "idTipoEmpleado=" + idTipoEmpleado + ", " : "")
				+ (codigoTipoEmpleado != null ? "codigoTipoEmpleado=" + codigoTipoEmpleado + ", " : "")
				+ (nombreTipoEmpleado != null ? "nombreTipoEmpleado=" + nombreTipoEmpleado : "") + "]";
	}
	
}
