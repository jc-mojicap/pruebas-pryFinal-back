package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JoinColumn(name = "herramienta", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Herramienta herramienta;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;

    @JoinColumn(name = "creado_por", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Usuario creadoPor;

    @ManyToMany
    @JoinTable(
            name="solicitud_prueba",
            joinColumns=@JoinColumn(name="solicitud_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="prueba_id", referencedColumnName="id"))
    private List<Prueba> pruebas;

}
