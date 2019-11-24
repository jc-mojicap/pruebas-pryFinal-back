package edu.uniandes.pruebasautomatizadas.servicios.endpoint.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO Empresa.
 */
public class EmpresaDTO implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador de la empresa.
     */
    private Integer empresaId;
   
    /**
     * Nombre de la empresa.
     */
    private String nombre;
   
    /**
     * Codigo de la empresa
     */
    private String codigoEmpresa;
    
    /**
     * Empresa inactiva.
     */
    private Boolean inactivo;
    
    /**
     * Ultimo usuario que modifica la empresa.
     */
    private Long usuarioModifica;
    
    /**
     * Ultima fecha de modificacion.
     */
    private Date fechaModifica;

    /**
     * Constructor.
     */
    public EmpresaDTO() {
        
    }  

    /**
     * getEmpresaId.
     *
     * @return Long
     */
    public Integer getEmpresaId() {
        return empresaId;
    }

    /**
     * setEmpresaId.
     *
     * @param empresaId Identificador de la empresa.
     */
    public void setEmpresaId(final Integer empresaId) {
        this.empresaId = empresaId;
    }

    /**
     * getNombre.
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nombre de la empresa.     
     * @param nombre Nombre de la empresa.
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Empresa inactiva.
     *
     * @return Boolean
     */
    public Boolean getInactivo() {
        return inactivo;
    }

    /**
     * setInactivo.
     * @param inactivo Boolean
     */
    public void setInactivo(final Boolean inactivo) {
        this.inactivo = inactivo;
    }   

    /**
     * hashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.empresaId);
        return hash;
    }
    
    /**
     * getUsuarioModifica.
     * @return Long
     */
    public Long getUsuarioModifica() {
        return usuarioModifica;
    }

    /**
     * setUsuarioModifica.
     * @param usuarioModifica Identificador del ultimo usuario que modifica la empresa.
     */
    public void setUsuarioModifica(final Long usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    /**
     * getFechaModifica.
     * @return Date
     */
    public Date getFechaModifica() {
        return fechaModifica;
    }

    /**
     * setFechaModifica.
     * @param fechaModifica Ultima fecha de modificacion.
     */
    public void setFechaModifica(final Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }
    
    /**
     * getCodigoEmpresa.
     * @return String
     */
    public String getCodigoEmpresa() {
		return codigoEmpresa;
	}

    /**
     * setCodigoEmpresa.
     * @param codigoEmpresa Codigo de la empresa.
     */
	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

    /**
     * equals.
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaDTO other = (EmpresaDTO) obj;
        if (!Objects.equals(this.empresaId, other.empresaId)) {
            return false;
        }
        return true;
    }

}
