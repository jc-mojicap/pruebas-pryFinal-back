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
@Table(name="persona")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "identificacion", nullable = false)
	private String identificacion;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "primer_apellido", nullable = false)
	private String primerApellido;
	
	@Column(name = "segundo_apellido", nullable = false)
	private String segundoApellido;
	
	@Column(name = "direccion_electronica", nullable = false)
	private String direccionElectronica;
	
	@Column(name = "direccion_contacto", nullable = false)
	private String direccionContacto;
	
	@Column(name = "telefono_contacto", nullable = false)
	private String telefonoContacto;
	
	@Column(name = "telefono_celular", nullable = false)
	private String telefonoCelular;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@JoinColumn(name = "tipoIdentificacion", referencedColumnName = "id_tipo_identificacion", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TipoIdentificacion tipoIdentificacion;

	public Persona() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getDireccionElectronica() {
		return direccionElectronica;
	}
	public void setDireccionElectronica(String direccionElectronica) {
		this.direccionElectronica = direccionElectronica;
	}
	public String getDireccionContacto() {
		return direccionContacto;
	}
	public void setDireccionContacto(String direccionContacto) {
		this.direccionContacto = direccionContacto;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Persona [" + (id != null ? "id=" + id + ", " : "")
				+ (identificacion != null ? "identificacion=" + identificacion + ", " : "")
				+ (nombres != null ? "nombres=" + nombres + ", " : "")
				+ (primerApellido != null ? "primerApellido=" + primerApellido + ", " : "")
				+ (segundoApellido != null ? "segundoApellido=" + segundoApellido + ", " : "")
				+ (direccionElectronica != null ? "direccionElectronica=" + direccionElectronica + ", " : "")
				+ (direccionContacto != null ? "direccionContacto=" + direccionContacto + ", " : "")
				+ (telefonoContacto != null ? "telefonoContacto=" + telefonoContacto + ", " : "")
				+ (telefonoCelular != null ? "telefonoCelular=" + telefonoCelular + ", " : "")
				+ (estado != null ? "estado=" + estado + ", " : "")
				+ (fechaNacimiento != null ? "fechaNacimiento=" + fechaNacimiento + ", " : "")
				+ (tipoIdentificacion != null ? "tipoIdentificacion=" + tipoIdentificacion : "") + "]";
	}
	
}
