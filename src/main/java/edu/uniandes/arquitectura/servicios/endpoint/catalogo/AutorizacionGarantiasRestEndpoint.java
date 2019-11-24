package edu.uniandes.arquitectura.servicios.endpoint.catalogo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.uniandes.arquitectura.servicios.dao.model.AutorizacionGarantia;
import edu.uniandes.arquitectura.servicios.endpoint.BaseRest;
import edu.uniandes.arquitectura.servicios.service.catalogo.iface.AutorizacionGarantiaService;

@RestController
public class AutorizacionGarantiasRestEndpoint extends BaseRest {

	/**
     * Nombre del modulo utilizado como prefijo de la URL.
     */
    private static final String MODULO = "catalogo";
    
    /**
     * Nombre de la entidad
     */
    private static final String ENTIDAD = "autorizacion";
    
    @Autowired
    private AutorizacionGarantiaService autorizacionService;

    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD, method = RequestMethod.GET)
    public List<AutorizacionGarantia> listar() {
        List<AutorizacionGarantia> autorizaciones;
        //autorizaciones = AutorizacionGarantiasMapper.INSTANCE.AutorizacionGarantiasToAutorizacionGarantiasDTO(autorizacionService.listarTodas());
        autorizaciones = autorizacionService.listarTodas();
        return autorizaciones;
    }
    
    @RequestMapping(value = "/" + MODULO + "/" + ENTIDAD + "/autorizar", method = RequestMethod.POST)
    public List<AutorizacionGarantia> autorizarSolicitud(@RequestBody ArrayList<AutorizacionGarantia> autorizaciones) {
        ArrayList<AutorizacionGarantia> autorizacionesEntities;
//        autorizacionesEntities = AutorizacionGarantiasMapper.INSTANCE.AutorizacionGarantiasDTOToAutorizacionGarantias(autorizaciones);
//        autorizaciones = AutorizacionGarantiasMapper.INSTANCE.AutorizacionGarantiasToAutorizacionGarantiasDTO(autorizacionService.autorizarGarantia(autorizacionesEntities));
        autorizacionesEntities = autorizaciones;
        try{
        	autorizaciones = autorizacionService.autorizarGarantia(autorizacionesEntities);        	
        }catch (Exception e) {
			e.printStackTrace();
		}
        return autorizaciones;
    }
    
}
