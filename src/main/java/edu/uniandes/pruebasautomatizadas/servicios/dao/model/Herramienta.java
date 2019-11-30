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
@Table(name = "herramienta")
public class Herramienta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JoinColumn(name = "tipo_aplicacion", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private TipoAplicacion tipoAplicacion;

    @Column(name = "link", nullable = true)
    private String link;

    @JoinColumn(name = "ejecutor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Ejecutor ejecutor;

    @Column(name = "alto_pantalla", nullable = true)
    private Integer altoPantalla;

    @Column(name = "ancho_pantalla", nullable = true)
    private Integer anchoPantalla;

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
