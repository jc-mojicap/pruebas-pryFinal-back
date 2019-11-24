package edu.uniandes.arquitectura.servicios.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "persona", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private Persona persona;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean administrador;
    @Basic(optional = false)
    @Column(name = "codigo_usuario", nullable = false, length = 50)
    private String codigoUsuario;
    @Basic(optional = false)
    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombreUsuario;
    
    @Column(nullable=false, name="contrasena", length=255)
    private String contrasena;
    
    @ManyToMany
    @JoinTable(
        name="usuario_rol",
        joinColumns=@JoinColumn(name="usuario_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="rol_id", referencedColumnName="id"))
    private List<Rol> roles;
    @Basic(optional = false)
    @Column(nullable = false)
    private String estado;
    @Basic(optional = false)
    @Column(name = "usuario_modifica", nullable = false)
    private int usuarioModifica;
    @Basic(optional = false)
    @Column(name = "fecha_modifica", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifica;
    

    
    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, boolean administrador, String codigoUsuario, String nombreUsuario, String estado, int usuarioModifica, Date fechaModifica, String contrasena) {
        this.id = id;
        this.administrador = administrador;
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.estado = estado;
        this.contrasena= contrasena;
        this.usuarioModifica = usuarioModifica;
        this.fechaModifica = fechaModifica;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Usuario [" + (id != null ? "id=" + id + ", " : "")
				+ (persona != null ? "persona=" + persona + ", " : "") + "administrador=" + administrador + ", "
				+ (codigoUsuario != null ? "codigoUsuario=" + codigoUsuario + ", " : "")
				+ (nombreUsuario != null ? "nombreUsuario=" + nombreUsuario + ", " : "")
				+ (roles != null ? "roles=" + roles + ", " : "") + (estado != null ? "estado=" + estado + ", " : "")
				+ "usuarioModifica=" + usuarioModifica + ", "
				+ (fechaModifica != null ? "fechaModifica=" + fechaModifica : "") + "]";
	}    
}
