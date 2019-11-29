package edu.uniandes.pruebasautomatizadas.servicios.endpoint.back;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Herramienta;
import edu.uniandes.pruebasautomatizadas.servicios.endpoint.BaseRest;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.HerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HerramientaEndpoint extends BaseRest {

    @Autowired
    private HerramientaService herramientaService;

    @RequestMapping(value = "/herramienta", method = RequestMethod.GET)
    public List<Herramienta> listar() {
        System.out.println("lista herramientas");
        return herramientaService.buscarTodas();
    }

    @RequestMapping(value = "/herramienta", method = RequestMethod.POST)
    public Herramienta crearHerramienta(@RequestBody Herramienta herramienta) {
        System.out.println("lista herramientas");
        return herramientaService.crearHerramienta(herramienta);
    }
}
