package edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
