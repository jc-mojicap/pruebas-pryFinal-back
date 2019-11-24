package edu.uniandes.arquitectura.servicios.endpoint.dto;

public class TipoIdentificacionDTO {

	private Long idTipoIdentificacion;
	private String tipoIdentificacion;
	private String nombreTipoIdentificacion;
	
	public TipoIdentificacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdTipoIdentificacion() {
		return idTipoIdentificacion;
	}
	public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getNombreTipoIdentificacion() {
		return nombreTipoIdentificacion;
	}
	public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
		this.nombreTipoIdentificacion = nombreTipoIdentificacion;
	}
	
	
}
