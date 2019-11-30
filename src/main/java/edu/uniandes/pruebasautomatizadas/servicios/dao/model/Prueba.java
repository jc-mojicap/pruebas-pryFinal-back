package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "prueba")
public class Prueba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JoinColumn(name = "aplicacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Aplicacion aplicacion;

    @JoinColumn(name = "tipo_prueba", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private TipoPrueba tipoPrueba;

    @Column(name = "url_apk", nullable = true)
    private String url_apk = "https://apks-pruebas-automaticas.s3.amazonaws.com/es.usc.citius.servando.calendula_42.apk";

    @Column(name = "script", nullable = false)
    private String script;

    @Column(name = "descripcion", nullable = true)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = new Date();

    @Column(name = "fecha_actualizacion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion = new Date();

    @JoinColumn(name = "creado_por", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Usuario creadoPor;
}
