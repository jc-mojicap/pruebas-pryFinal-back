package edu.uniandes.pruebasautomatizadas.servicios.service.catalogo.iface;

import java.util.List;
import java.util.Optional;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Empresa;

/**
 * Servicios de negocio para el recurso Empresa.
 */
public interface EmpresaService {
    
    /**
     * Retorna una lista de todas las empresas (activas e inactivas).     
     * las activas o null para retornar todas.
     * @return Lista de empresa. Si no existen retorna una lista vacia
     */
    List<Empresa> listar();
    /**
     * Retorna una lista de las empresas.
     * @param inactivo true para retornar las inactivas, false para retornar
     * las activas o null para retornar todas.
     * @return Lista de empresa. Si no existen retorna una lista vacia
     */
    List<Empresa> listar(boolean inactivo);
    /**
     * Crear una nueva empresa.     
     * @param empresa Empresa a crear. No puede ser nulo.
     * @return Empresa creada.
     * @throws IllegalArgumentException Si la empresa es nula o si se le asigna 
     * un id a la empresa.
     */
    Empresa crear(Empresa empresa);
    /**
     * Actualizar una entidad.
     * @param entidad Entidad a actualizar. No puede ser nula ni venir con el id nulo.
     * @return Entidad actualizada.
     * @throws IllegalArgumentException Si no existe la entidad a actualizar.
     */
    Empresa actualizar(Empresa entidad);
    /**
     * Retorna una entidad de acuerdo al identificador.
     * @param id Identificador de la entidad.
     * @return Optional con la entidad. Si no existe, retorna un Optional vacio.
     */
    Optional<Empresa> obtenerPorId(Integer id);
    
    
}
