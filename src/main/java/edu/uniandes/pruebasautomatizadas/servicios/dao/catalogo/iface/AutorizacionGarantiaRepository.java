package edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.AutorizacionGarantia;


/**
 * CrudRepository de la entidad Empresa.
 * 
 */
public interface AutorizacionGarantiaRepository extends JpaRepository<AutorizacionGarantia, Long> {


    List<AutorizacionGarantia> findByIdAutorizacionOrderByCodigoAutorizacion(Long idAutorizacion);


    /**
     * Objeto empresa utilizando filtro de autorizacionGarantiaId.
     * 
     * @param idAutorizacionGarantia
     *            Filtro de idAutorizacionGarantia.
     * @return Object AutorizacionGarantia.
     */
    AutorizacionGarantia findByIdAutorizacion(Long idAutorizacion);
}
