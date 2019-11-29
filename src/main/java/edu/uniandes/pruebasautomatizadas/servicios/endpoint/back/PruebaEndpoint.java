package edu.uniandes.pruebasautomatizadas.servicios.endpoint.back;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Prueba;
import edu.uniandes.pruebasautomatizadas.servicios.endpoint.BaseRest;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PruebaEndpoint extends BaseRest {

    @Autowired
    private PruebaService pruebaService;

    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public List<Prueba> listar() {
        System.out.println("lista herramientas");
        return pruebaService.buscarTodas();
    }

    @RequestMapping(value = "/prueba", method = RequestMethod.POST)
    public Prueba crearPrueba(@RequestBody Prueba prueba) {
        System.out.println("lista herramientas");
        return pruebaService.crearPrueba(prueba);
    }
}
