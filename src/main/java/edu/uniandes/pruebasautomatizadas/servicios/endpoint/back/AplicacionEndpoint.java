package edu.uniandes.pruebasautomatizadas.servicios.endpoint.back;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.endpoint.BaseRest;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.AplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AplicacionEndpoint extends BaseRest {

    @Autowired
    private AplicacionService aplicacionService;

    @RequestMapping(value = "/aplicacion", method = RequestMethod.GET)
    public List<Aplicacion> listar() {
        System.out.println("lista aplicaciones");
        return aplicacionService.buscarTodas();
    }

}
