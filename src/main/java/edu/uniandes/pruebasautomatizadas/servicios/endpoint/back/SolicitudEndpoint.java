package edu.uniandes.pruebasautomatizadas.servicios.endpoint.back;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Solicitud;
import edu.uniandes.pruebasautomatizadas.servicios.endpoint.BaseRest;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolicitudEndpoint extends BaseRest {

    @Autowired
    private SolicitudService solicitudService;

    @RequestMapping(value = "/solicitud", method = RequestMethod.GET)
    public List<Solicitud> listar() {
        System.out.println("lista herramientas");
        return solicitudService.buscarTodas();
    }

    @RequestMapping(value = "/solicitud", method = RequestMethod.POST)
    public Solicitud crearSolicitud(@RequestBody Solicitud solicitud) {
        System.out.println("lista herramientas");
        return solicitudService.crearSolicitud(solicitud);
    }
}
