package edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
