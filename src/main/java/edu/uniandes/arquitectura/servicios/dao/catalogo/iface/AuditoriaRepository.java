package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {

	List<Auditoria> findByTablaModificada(String tablaModificada);
	
}
