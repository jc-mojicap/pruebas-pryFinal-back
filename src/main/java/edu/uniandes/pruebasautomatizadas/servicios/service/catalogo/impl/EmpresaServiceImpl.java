package edu.uniandes.pruebasautomatizadas.servicios.service.catalogo.impl;

import edu.uniandes.pruebasautomatizadas.servicios.comun.RequestScope;
import edu.uniandes.pruebasautomatizadas.servicios.comun.ValidateUtil;
import edu.uniandes.pruebasautomatizadas.servicios.dao.catalogo.iface.EmpresaRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Empresa;
import edu.uniandes.pruebasautomatizadas.servicios.service.catalogo.iface.EmpresaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacion de los servicios de negocio para el recurso Empresa.
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {
    
    /**
     * RequestScope.
     */
    @Autowired
    private RequestScope requestScope;
    
    /**
     * EmpresaRepository.
     */
    @Autowired 
    private EmpresaRepository empresaRepository;
    
    @Override
    public List<Empresa> listar() {
        List<Empresa> empresas = new ArrayList<>();        
        empresaRepository.findAll().forEach(empresas::add);        
        return empresas;
    }
    
    @Override
    public List<Empresa> listar(final boolean inactivo) {                
        return empresaRepository.findByInactivoOrderByNombre(inactivo);        
    }

    @Override
    @Transactional
    public Empresa crear(final Empresa empresa) {                
        ValidateUtil.notNull(empresa, "El parametro empresa no puede ser nulo."); 
        ValidateUtil.isNull(empresa.getEmpresaId(), 
                "El atributo empresaId debe ser nulo o vacio.");        
        empresa.setUsuarioModifica(requestScope.getIdentificacion().getId());
        empresa.setFechaModifica(new Date());
        return empresaRepository.save(empresa);
    }
    
    @Override
    @Transactional
    public Empresa actualizar(final Empresa entidad) {
        ValidateUtil.notNull(entidad, "El parametro entidad no puede ser nulo.");
        ValidateUtil.notNull(entidad.getEmpresaId(), 
                "El id de la entidad no puede ser nulo.");
        Empresa anterior = empresaRepository.findOne(entidad.getEmpresaId());
        if (anterior == null) {
            throw new IllegalArgumentException(
                    String.format("No existe la entidad con id=%s", entidad.getEmpresaId()));
        }        
        entidad.setUsuarioModifica(requestScope.getIdentificacion().getId());
        entidad.setFechaModifica(new Date());
        return empresaRepository.save(entidad);
    }

    @Override
    public Optional<Empresa> obtenerPorId(final Integer id) {
    	Validate.notNull(id, "El parametro id no puede ser nulo.");
        Empresa entidad = empresaRepository.findOne(id);
        return entidad != null ? Optional.of(entidad) : Optional.empty();
    }
}
