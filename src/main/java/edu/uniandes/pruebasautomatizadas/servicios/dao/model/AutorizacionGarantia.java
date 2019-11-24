package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="autorizacion_garantia")
public class AutorizacionGarantia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autorizacion", nullable = false)
	private Long idAutorizacion;
	
	@Column(name = "codigo_autorizacion", nullable = false)
	private String codigoAutorizacion;
	
	@Column(name = "especificacion_autorizacion", nullable = false)
	private String especificacionAutorizacion;
	
	@Column(name = "fecha_autorizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaAutorizacion;
	
	@Column(name = "fecha_actualizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@JoinColumn(name = "empleado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Empleado empleado;
	
	@JoinColumn(name = "garantia", referencedColumnName = "id_garantia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Garantia garantia;
	
	public AutorizacionGarantia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdAutorizacion() {
		return idAutorizacion;
	}
	public void setIdAutorizacion(Long idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}
	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}
	public String getEspecificacionAutorizacion() {
		return especificacionAutorizacion;
	}
	public void setEspecificacionAutorizacion(String especificacionAutorizacion) {
		this.especificacionAutorizacion = especificacionAutorizacion;
	}
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Garantia getGarantia() {
		return garantia;
	}
	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutorizacion == null) ? 0 : idAutorizacion.hashCode());
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
		AutorizacionGarantia other = (AutorizacionGarantia) obj;
		if (idAutorizacion == null) {
			if (other.idAutorizacion != null)
				return false;
		} else if (!idAutorizacion.equals(other.idAutorizacion))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AutorizacionGarantia [" + (idAutorizacion != null ? "idAutorizacion=" + idAutorizacion + ", " : "")
				+ (codigoAutorizacion != null ? "codigoAutorizacion=" + codigoAutorizacion + ", " : "")
				+ (especificacionAutorizacion != null
						? "especificacionAutorizacion=" + especificacionAutorizacion + ", " : "")
				+ (fechaAutorizacion != null ? "fechaAutorizacion=" + fechaAutorizacion + ", " : "")
				+ (fechaActualizacion != null ? "fechaActualizacion=" + fechaActualizacion + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (garantia != null ? "garantia=" + garantia : "") + "]";
	}
	
}
