package edu.uniandes.pruebasautomatizadas.servicios.dao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "ejecutor")
public class Ejecutor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String ejecutor;

    @Basic(optional = false)
    @Column(nullable = false)
    private String version;
}
