package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Carro;
import edu.uniandes.arquitectura.servicios.dao.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

	Compra findByCarro(Carro carro);
}
