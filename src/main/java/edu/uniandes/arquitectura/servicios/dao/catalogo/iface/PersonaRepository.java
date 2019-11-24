package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
