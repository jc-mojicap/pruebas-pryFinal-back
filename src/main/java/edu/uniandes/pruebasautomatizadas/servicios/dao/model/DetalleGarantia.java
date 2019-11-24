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
@Table(name="detalle_garantia")
public class DetalleGarantia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_garantia", nullable = false)
	private Long idDetalleGarantia;
	
	@JoinColumn(name = "garantia", referencedColumnName = "id_garantia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Garantia garantia;
	
	@Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "especificacion_detalle", nullable = false)
	private String especificacionDetalle;
	
	@Column(name = "cantidad_solicitada", nullable = false)
	private Integer cantidadSolicitada;
	
	@JoinColumn(name = "referencia", referencedColumnName = "id_referencia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Referencia referencia;
	
	public DetalleGarantia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdDetalleGarantia() {
		return idDetalleGarantia;
	}
	public void setIdDetalleGarantia(Long idDetalleGarantia) {
		this.idDetalleGarantia = idDetalleGarantia;
	}
	public Garantia getGarantia() {
		return garantia;
	}
	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
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
	public String getEspecificacionDetalle() {
		return especificacionDetalle;
	}
	public void setEspecificacionDetalle(String especificacionDetalle) {
		this.especificacionDetalle = especificacionDetalle;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
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
		result = prime * result + ((idDetalleGarantia == null) ? 0 : idDetalleGarantia.hashCode());
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
		DetalleGarantia other = (DetalleGarantia) obj;
		if (idDetalleGarantia == null) {
			if (other.idDetalleGarantia != null)
				return false;
		} else if (!idDetalleGarantia.equals(other.idDetalleGarantia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetalleGarantia [" + (idDetalleGarantia != null ? "idDetalleGarantia=" + idDetalleGarantia + ", " : "")
				+ (garantia != null ? "garantia=" + garantia + ", " : "")
				+ (fechaRegistro != null ? "fechaRegistro=" + fechaRegistro + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (especificacionDetalle != null ? "especificacionDetalle=" + especificacionDetalle + ", " : "")
				+ (cantidadSolicitada != null ? "cantidadSolicitada=" + cantidadSolicitada + ", " : "")
				+ (referencia != null ? "referencia=" + referencia : "") + "]";
	}
	
	
}
