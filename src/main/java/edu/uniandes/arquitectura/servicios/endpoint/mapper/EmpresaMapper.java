package edu.uniandes.arquitectura.servicios.endpoint.mapper;

import edu.uniandes.arquitectura.servicios.dao.model.Empresa;
import edu.uniandes.arquitectura.servicios.endpoint.dto.EmpresaDTO;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Clase que permite transformar un Empresa en un EmpresaDto.
 */
//@Mapper
public interface EmpresaMapper {
    
    /**
     * Instancia de la clase.
     */
//    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    /**
     * Transforma un EmpresaDto en un Empresa.
     * @param empresaDto Objeto a transformar.
     * @return Objeto transformado.
     */    
//    Empresa empresaDtoToEmpresa(EmpresaDTO empresaDto);
    
    /**
     * Transforma un Empresa en un EmpresaDto.
     * @param empresa Objeto a tranformar.
     * @return Objeto transformado.
     */    
//    EmpresaDTO empresaToEmpresaDto(Empresa empresa);
        
    /**
     * Transforma una lista de Empresa a una lista de EmpresaDto.
     * @param empresas Lista a transformar.
     * @return Lista transformada.
     */
//    List<EmpresaDTO> empresasToEmpresasDto(List<Empresa> empresas);
}
