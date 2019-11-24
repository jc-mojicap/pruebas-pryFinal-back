package edu.uniandes.arquitectura.servicios.dao.model;

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
@Table(name="detalle_autorizacion_garantia")
public class DetalleAutorizacionGarantia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_autorizacion", nullable = false)
	private Long idDetalleAutorizacion;
	
	@JoinColumn(name = "autorizacionGarantia", referencedColumnName = "id_autorizacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private AutorizacionGarantia autorizacionGarantia;
	
	@Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "especificacion_reparacion", nullable = false)
	private String especificacionReparacion;
	
	@Column(name = "cantidad_autorizada", nullable = false)
	private Integer cantidadAutorizada;
	
	@JoinColumn(name = "referencia", referencedColumnName = "id_referencia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Referencia referencia;
	
	public DetalleAutorizacionGarantia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDetalleAutorizacion() {
		return idDetalleAutorizacion;
	}
	public void setIdDetalleAutorizacion(Long idDetalleAutorizacion) {
		this.idDetalleAutorizacion = idDetalleAutorizacion;
	}
	public AutorizacionGarantia getAutorizacionGarantia() {
		return autorizacionGarantia;
	}
	public void setAutorizacionGarantia(AutorizacionGarantia autorizacionGarantia) {
		this.autorizacionGarantia = autorizacionGarantia;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEspecificacionReparacion() {
		return especificacionReparacion;
	}
	public void setEspecificacionReparacion(String especificacionReparacion) {
		this.especificacionReparacion = especificacionReparacion;
	}
	public Integer getCantidadAutorizada() {
		return cantidadAutorizada;
	}
	public void setCantidadAutorizada(Integer cantidadAutorizada) {
		this.cantidadAutorizada = cantidadAutorizada;
	}
	public Referencia getReferencia() {
		return referencia;
	}
	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDetalleAutorizacion == null) ? 0 : idDetalleAutorizacion.hashCode());
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
		DetalleAutorizacionGarantia other = (DetalleAutorizacionGarantia) obj;
		if (idDetalleAutorizacion == null) {
			if (other.idDetalleAutorizacion != null)
				return false;
		} else if (!idDetalleAutorizacion.equals(other.idDetalleAutorizacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleAutorizacionGarantia ["
				+ (idDetalleAutorizacion != null ? "idDetalleAutorizacion=" + idDetalleAutorizacion + ", " : "")
				+ (autorizacionGarantia != null ? "autorizacionGarantia=" + autorizacionGarantia + ", " : "")
				+ (fechaRegistro != null ? "fechaRegistro=" + fechaRegistro + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (especificacionReparacion != null ? "especificacionReparacion=" + especificacionReparacion + ", "
						: "")
				+ (cantidadAutorizada != null ? "cantidadAutorizada=" + cantidadAutorizada + ", " : "")
				+ (referencia != null ? "referencia=" + referencia : "") + "]";
	}
	
}
