package edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.TipoPrueba;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPruebaRepository extends JpaRepository<TipoPrueba, Long> {
}
