package edu.uniandes.arquitectura.servicios.dao.catalogo.iface;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.uniandes.arquitectura.servicios.dao.model.Empresa;

/**
 * CrudRepository de la entidad Empresa.
 * 
 */
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    /**
     * Listado de empresas utilizando filtor de inactivo.
     * 
     * @param inactivo
     *            Filtro de inactivo.
     * @return Listado con las empresas. Si no existe retorna una lista vacia.
     */
    List<Empresa> findByInactivoOrderByNombre(boolean inactivo);

    List<Empresa> findByEmpresaIdOrderByNombre(Integer id);

    /**
     * Listado de empresas utilizando filtor de inactivo.
     * 
     * @param inactivo
     *            Filtro de inactivo.
     * @return Listado con las empresas. Si no existe retorna una lista vacia.
     */
    List<Empresa> findByInactivo(boolean inactivo);

    /**
     * Objeto empresa utilizando filtro de empresaId.
     * 
     * @param empresaId
     *            Filtro de empresaId.
     * @return Objeto Empresa.
     */
    Empresa findByEmpresaId(Integer empresaId);
}
