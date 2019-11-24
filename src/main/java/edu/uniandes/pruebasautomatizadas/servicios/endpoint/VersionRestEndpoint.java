package edu.uniandes.pruebasautomatizadas.servicios.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint utilitario utilizado para revisar la version de la aplicacion
 * desplegada en el entorno.
 */
@RestController
public class VersionRestEndpoint extends BaseRest {
   
    /**
     * Version de la aplicacion configurada en el archivo application.properties.
     */
    @Value("${servicios.version}")
    private String version;                     
        
   /**
     * Permite ver la version de la aplicacion.     
     * Peticion:
     * - URL: /version
     * - Metodo: GET     
     * Autenticacion: no requerida
     * Respuesta:
     * - HTTP code: 200
     * - Cuerpo: version de la aplicacion
     */
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String version() {
        return version;
    }
}
