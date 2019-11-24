package edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Trazabilidad;

public interface TrazabilidadRepository extends JpaRepository<Trazabilidad, Integer> {

	List<Trazabilidad> findByNivelTraza(String nivelTraza);
	
}
