package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="referencia")
public class Referencia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_referencia", nullable = false)
	private Long idReferencia;
	
	@Column(name = "codigo_referencia", nullable = false)
	private String codigoReferencia;
	
	@Column(name = "nombre_referencia", nullable = false)
	private String nombreReferencia;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "presentacion", nullable = false)
	private String presentacion;
	
	@Column(name = "marca", nullable = false)
	private String marca;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "linea", nullable = false)
	private Integer linea;
	
	@Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "fecha_actualizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaActualizacion;
	
	@Column(name = "valor_voluntario", nullable = false)
	private Double valorUnitario;
	
	public Referencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdReferencia() {
		return idReferencia;
	}
	public void setIdReferencia(Long idReferencia) {
		this.idReferencia = idReferencia;
	}
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	public String getNombreReferencia() {
		return nombreReferencia;
	}
	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getLinea() {
		return linea;
	}
	public void setLinea(Integer linea) {
		this.linea = linea;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReferencia == null) ? 0 : idReferencia.hashCode());
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
		Referencia other = (Referencia) obj;
		if (idReferencia == null) {
			if (other.idReferencia != null)
				return false;
		} else if (!idReferencia.equals(other.idReferencia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Referencia [" + (idReferencia != null ? "idReferencia=" + idReferencia + ", " : "")
				+ (codigoReferencia != null ? "codigoReferencia=" + codigoReferencia + ", " : "")
				+ (nombreReferencia != null ? "nombreReferencia=" + nombreReferencia + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (presentacion != null ? "presentacion=" + presentacion + ", " : "")
				+ (marca != null ? "marca=" + marca + ", " : "") + (modelo != null ? "modelo=" + modelo + ", " : "")
				+ (linea != null ? "linea=" + linea + ", " : "")
				+ (fechaCreacion != null ? "fechaCreacion=" + fechaCreacion + ", " : "")
				+ (fechaActualizacion != null ? "fechaActualizacion=" + fechaActualizacion + ", " : "")
				+ (valorUnitario != null ? "valorUnitario=" + valorUnitario : "") + "]";
	}
		
}
