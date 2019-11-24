package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
