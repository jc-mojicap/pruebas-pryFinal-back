package edu.uniandes.arquitectura.servicios.dao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empresa_id", nullable = false)
    private Integer empresaId;
    @Basic(optional = false)
    @Column(nullable = false, length = 250)
    private String nombre;
    @Column(name = "codigo_empresa", length = 50)
    private String codigoEmpresa;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String nit;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String direccion;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String telefono;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean inactivo;
    @Basic(optional = false)
    @Column(name = "usuario_modifica", nullable = false)
    private int usuarioModifica;
    @Basic(optional = false)
    @Column(name = "fecha_modifica", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifica;
                        
    public Empresa() {
    }

    public Empresa(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public Empresa(Integer empresaId, String nombre, String nit, String direccion, String telefono, boolean inactivo, int usuarioModifica, Date fechaModifica) {
        this.empresaId = empresaId;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.inactivo = inactivo;
        this.usuarioModifica = usuarioModifica;
        this.fechaModifica = fechaModifica;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(boolean inactivo) {
        this.inactivo = inactivo;
    }

    public int getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(int usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empresaId != null ? empresaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.empresaId == null && other.empresaId != null) || (this.empresaId != null && !this.empresaId.equals(other.empresaId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Empresa [" + (empresaId != null ? "empresaId=" + empresaId + ", " : "")
				+ (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (codigoEmpresa != null ? "codigoEmpresa=" + codigoEmpresa + ", " : "")
				+ (nit != null ? "nit=" + nit + ", " : "") + (direccion != null ? "direccion=" + direccion + ", " : "")
				+ (telefono != null ? "telefono=" + telefono + ", " : "") + "inactivo=" + inactivo
				+ ", usuarioModifica=" + usuarioModifica + ", "
				+ (fechaModifica != null ? "fechaModifica=" + fechaModifica : "") + "]";
	}
    
}
