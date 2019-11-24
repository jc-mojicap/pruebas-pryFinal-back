package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Trazabilidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private int id;
	
	@Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Basic(optional = false)
    @Column(name = "nivel_traza", nullable = false)
	private String nivelTraza;
	
	@Basic(optional = false)
    @Column(name = "mensaje", nullable = false, length=4000)
	private String mensaje;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNivelTraza() {
		return nivelTraza;
	}

	public void setNivelTraza(String nivelTraza) {
		this.nivelTraza = nivelTraza;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
