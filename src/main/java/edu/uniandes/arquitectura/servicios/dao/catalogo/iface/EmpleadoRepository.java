package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
