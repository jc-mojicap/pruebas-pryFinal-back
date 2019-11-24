package edu.uniandes.arquitectura.servicios.endpoint.catalogo;

import edu.uniandes.arquitectura.servicios.dao.model.Empresa;
import edu.uniandes.arquitectura.servicios.endpoint.BaseRest;
import edu.uniandes.arquitectura.servicios.endpoint.dto.EmpresaDTO;
import edu.uniandes.arquitectura.servicios.endpoint.mapper.EmpresaMapper;
import edu.uniandes.arquitectura.servicios.service.catalogo.iface.EmpresaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint REST del recurso Empresa.
 *
 */
@RestController
public class EmpresaRestEndpoint extends BaseRest {

    /**
     * Nombre del modulo utilizado como prefijo de la URL.
     */
    private static final String MODULO = "catalogo";
    
    /**
     * Nombre de la entidad
     */
    private static final String ENTIDAD = "empresa";

    /**
     * EmpresaService.
     */
    @Autowired
    private EmpresaService empresaService;

    /**
     * Permite listar las empresas. Si el parametro inactivo no es enviado
     * retorna todas. <br>
     * Peticion: <br>
     * - URL: /catalogo/empresa?inactivo={boolean} <br>
     * - Metodo: GET <br>
     * - Parametros: <br>
     * -- activo (Opcional): valores posibles: true, false o vacio. <br>
     * Autenticacion: no requerida <br>
     * Respuesta: <br>
     * - HTTP code: 200 <br>
     * - Cuerpo: Lista con las empresas. 
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD, method = RequestMethod.GET)
    public List<EmpresaDTO> listar(
            @RequestParam(value = "inactivo", required = false) final Boolean inactivo) {
        List<Empresa> empresas;
        if (inactivo != null) {
            empresas = empresaService.listar(inactivo);
        } else {
            empresas = empresaService.listar();
        }
//        return EmpresaMapper.INSTANCE.empresasToEmpresasDto(empresas);
        return null;
        
    }

    /**
     * Permite crear una empresa. <br>
     * Peticion: <br>
     * - URL: /catalogo <br>
     * - Metodo: POST <br>
     * Cuerpo: <br>
     * - Objeto objeto EmpresaDTO sin el atributo empresaId. <br>
     * Autenticacion: requerida por token.
     * Respuesta: <br>   
     * - Cabecera HTTP: <br>
     * -- Status code: 201 <br>
     * -- Location: URL para obtener el recurso.
     * - Cuerpo: Departamento con el id asignado.
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD, method = RequestMethod.POST)
    public ResponseEntity<EmpresaDTO> crear(@RequestBody final EmpresaDTO dto) 
            throws URISyntaxException {
//        Empresa empresa = empresaService.crear(
//                EmpresaMapper.INSTANCE.empresaDtoToEmpresa(dto));
//        EmpresaDTO res = EmpresaMapper.INSTANCE.empresaToEmpresaDto(empresa);
//        return ResponseEntity.created(new URI(String.format("%s/%s/%s/%s", 
//                CONTEXTO, MODULO, ENTIDAD, res.getEmpresaId()))).body(res); 
    	return null;
    }
    
    /**
     * Permite actualizar una empresa. <br>
     * Peticion: <br>
     * - URL: /catalogo/empresa <br>
     * - Metodo: PUT <br>
     * Cuerpo: <br>
     * Objeto EmpresaDTO. <br>
     * Autenticacion: requerida por token. <br>
     * Respuesta: <br>
     * - Cabecera HTTP:
     * -- Status code: 200 <br>
     * - Cuerpo: EmpresaDTO actualizado.
     */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD, method = RequestMethod.PUT)
    public EmpresaDTO actualizar(@RequestBody final EmpresaDTO dto) {
//        Empresa empresa = empresaService.actualizar(
//                EmpresaMapper.INSTANCE.empresaDtoToEmpresa(dto));
//        return EmpresaMapper.INSTANCE.empresaToEmpresaDto(empresa);
    	return null;
    }
    
    /**
     * Permite obtener una empresa por id. <br>
     * Peticion: <br>
     * - URL: /catalogo/empresa/{id} <br>
     * - Metodo: GET <br>
     * - Parametros: <br>
     * -- id: Id numerico de la empresa a obtener. <br>
     * Autenticacion: requerida por token. <br>
     * Respuesta: <br>
     * - Si la empresa existe: <br>
     * -- Cabecera HTTP con status code 200 <br>
     * -- Cuerpo: Departamento. <br>
     * - Si la empresa no existe: <br>
     * -- Cabecera HTTP con status code 404 (not found).
     *//*
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmpresaDTO> obtenerPorId(@PathVariable(name = "id") final Long id) {
        Optional<Empresa> empresa = empresaService.obtenerPorId(id);
        if (empresa.isPresent()) {
            return ResponseEntity.ok(EmpresaMapper.INSTANCE.empresaToEmpresaDTO(empresa.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }        
    }    */
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmpresaDTO> obtenerPorId(@PathVariable(name = "id") final Integer id) {
//        Optional<Empresa> empresa = empresaService.obtenerPorId(id);
//        if (empresa.isPresent()) {
//            return ResponseEntity.ok(EmpresaMapper.INSTANCE.empresaToEmpresaDto(empresa.get()));
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    	return null;
    }
}
