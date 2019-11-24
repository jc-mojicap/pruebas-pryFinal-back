package edu.uniandes.arquitectura.servicios.endpoint.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import edu.uniandes.arquitectura.servicios.dao.model.AutorizacionGarantia;
import edu.uniandes.arquitectura.servicios.endpoint.dto.AutorizacionGarantiaDTO;

//@Mapper
public interface AutorizacionGarantiasMapper {

	/**
     * Instancia de la clase.
     */
//	AutorizacionGarantiasMapper INSTANCE = Mappers.getMapper(AutorizacionGarantiasMapper.class);

    /**
     * Transforma un AutorizacionGarantiaDTO en un AutorizacionGarantia.
     * @param empresaDto Objeto a transformar.
     * @return Objeto transformado.
     */
//	@Mappings({
//		@Mapping(source="empleado", target="empleado.id"),
//		@Mapping(source="garantia", target="garantia.idGarantia")
//	})
//    AutorizacionGarantia AutorizacionGarantiaDTOToAutorizacionGarantia(AutorizacionGarantiaDTO AutorizacionGarantiaDto);
    
    /**
     * Transforma un AutorizacionGarantia en un AutorizacionGarantiaDTO.
     * @param empresa Objeto a tranformar.
     * @return Objeto transformado.
     */
//	@Mappings({
//		@Mapping(source="empleado", target="empleado.id"),
//		@Mapping(source="garantia.idGarantia", target="garantia")
//	})
//	AutorizacionGarantiaDTO AutorizacionGarantiaToAutorizacionGarantiaDTO(AutorizacionGarantia autorizacionGarantia);
        
    /**
     * Transforma una lista de AutorizacionGarantia a una lista de AutorizacionGarantiaDTO.
     * @param empresas Lista a transformar.
     * @return Lista transformada.
     */
//    ArrayList<AutorizacionGarantiaDTO> AutorizacionGarantiasToAutorizacionGarantiasDTO(List<AutorizacionGarantia> autorizacionGarantia);
    
    /**
     * Transforma una lista de AutorizacionGarantiaDTO a una lista de AutorizacionGarantia.
     * @param empresas Lista a transformar.
     * @return Lista transformada.
     */
//    ArrayList<AutorizacionGarantia> AutorizacionGarantiasDTOToAutorizacionGarantias(ArrayList<AutorizacionGarantiaDTO> autorizacionGarantia);
	
}
