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
@Table(name="garantia")
public class Garantia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_garantia", nullable = false)
	private Long idGarantia;
	
	@Column(name = "codigo_garantia", nullable = false)
	private String codigoGarantia;
	
	@Column(name = "descripcion_garantia", nullable = false)
	private String descripcionGarantia;
	
	@Column(name = "motivo_garantia", nullable = false)
	private String motivoGarantia;
	
	@JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Cliente cliente;
	
	@JoinColumn(name = "carro", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Carro carro;
	
	@Column(name = "fecha_solicitud", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaSolicitud;
	
	@Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@Column(name = "fecha_actualizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "tipo_garantia", nullable = false)
	private String tipoGarantia;
	
	@JoinColumn(name = "responsableGarantia", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Empleado responsableGarantia;
	
	@JoinColumn(name = "responsableAutorizacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Empleado responsableAutorizacion;
	
	@Column(name = "observaciones", nullable = false)
	private String observaciones;
	
	public Garantia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdGarantia() {
		return idGarantia;
	}
	public void setIdGarantia(Long idGarantia) {
		this.idGarantia = idGarantia;
	}
	public String getCodigoGarantia() {
		return codigoGarantia;
	}
	public void setCodigoGarantia(String codigoGarantia) {
		this.codigoGarantia = codigoGarantia;
	}
	public String getDescripcionGarantia() {
		return descripcionGarantia;
	}
	public void setDescripcionGarantia(String descripcionGarantia) {
		this.descripcionGarantia = descripcionGarantia;
	}
	public String getMotivoGarantia() {
		return motivoGarantia;
	}
	public void setMotivoGarantia(String motivoGarantia) {
		this.motivoGarantia = motivoGarantia;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	public String getTipoGarantia() {
		return tipoGarantia;
	}
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia = tipoGarantia;
	}
	public Empleado getResponsableGarantia() {
		return responsableGarantia;
	}
	public void setResponsableGarantia(Empleado responsableGarantia) {
		this.responsableGarantia = responsableGarantia;
	}
	public Empleado getResponsableAutorizacion() {
		return responsableAutorizacion;
	}
	public void setResponsableAutorizacion(Empleado responsableAutorizacion) {
		this.responsableAutorizacion = responsableAutorizacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGarantia == null) ? 0 : idGarantia.hashCode());
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
		Garantia other = (Garantia) obj;
		if (idGarantia == null) {
			if (other.idGarantia != null)
				return false;
		} else if (!idGarantia.equals(other.idGarantia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Garantia [" + (idGarantia != null ? "idGarantia=" + idGarantia + ", " : "")
				+ (codigoGarantia != null ? "codigoGarantia=" + codigoGarantia + ", " : "")
				+ (descripcionGarantia != null ? "descripcionGarantia=" + descripcionGarantia + ", " : "")
				+ (motivoGarantia != null ? "motivoGarantia=" + motivoGarantia + ", " : "")
				+ (cliente != null ? "cliente=" + cliente + ", " : "") + (carro != null ? "carro=" + carro + ", " : "")
				+ (fechaSolicitud != null ? "fechaSolicitud=" + fechaSolicitud + ", " : "")
				+ (fechaRegistro != null ? "fechaRegistro=" + fechaRegistro + ", " : "")
				+ (fechaActualizacion != null ? "fechaActualizacion=" + fechaActualizacion + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (tipoGarantia != null ? "tipoGarantia=" + tipoGarantia + ", " : "")
				+ (responsableGarantia != null ? "responsableGarantia=" + responsableGarantia + ", " : "")
				+ (responsableAutorizacion != null ? "responsableAutorizacion=" + responsableAutorizacion + ", " : "")
				+ (observaciones != null ? "observaciones=" + observaciones : "") + "]";
	}
}
