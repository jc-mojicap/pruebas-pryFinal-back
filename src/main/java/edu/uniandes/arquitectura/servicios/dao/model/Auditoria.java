package edu.uniandes.arquitectura.servicios.dao.model;

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
public class Auditoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	private Long id;
	
	@Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	@Basic(optional = false)
    @Column(name = "tabla_modificada", nullable = false)
	private String tablaModificada;
	
	@Basic(optional = false)
    @Column(name = "registro_modificado", nullable = false)
	private Long registroModificado;
	
	@Basic(optional = false)
    @Column(name = "accion", nullable = false)
	private String accion;
	
	@Basic(optional = false)
    @Column(name = "campo_modificado", nullable = false)
	private String campoModificado;
	
	@Basic(optional = false)
    @Column(name = "valor_antiguo", nullable = false)
	private String valorAntiguo;
	
	@Basic(optional = false)
    @Column(name = "valor_nuevo", nullable = false)
	private String valorNuevo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTablaModificada() {
		return tablaModificada;
	}

	public void setTablaModificada(String tablaModificada) {
		this.tablaModificada = tablaModificada;
	}

	public Long getRegistroModificado() {
		return registroModificado;
	}

	public void setRegistroModificado(Long registroModificado) {
		this.registroModificado = registroModificado;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getCampoModificado() {
		return campoModificado;
	}

	public void setCampoModificado(String campoModificado) {
		this.campoModificado = campoModificado;
	}

	public String getValorAntiguo() {
		return valorAntiguo;
	}

	public void setValorAntiguo(String valorAntiguo) {
		this.valorAntiguo = valorAntiguo;
	}

	public String getValorNuevo() {
		return valorNuevo;
	}

	public void setValorNuevo(String valorNuevo) {
		this.valorNuevo = valorNuevo;
	}

	
}
