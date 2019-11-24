package edu.uniandes.pruebasautomatizadas.servicios.comun;

import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Clase que permite almacenar variables al contexto request.
 *
 */
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class RequestScope {

    /**
     * Identificacion del usuario.
     */
    private Identificacion identificacion;
    /**
     * IP del usuario.
     */
    private String ip = "";
    /**
     * Codigo de transaccion.
     */
    private final String transaccion;
    
    /**
     * Constructor por defecto.
     */
    public RequestScope() {
        UUID uuid = UUID.randomUUID();
        this.transaccion = uuid.toString().replace("-", "").toLowerCase();
    }

    /**
     * Identificacion del usuario.
     *
     * @return Identificacion
     */    
    public Identificacion getIdentificacion() {
        return identificacion;
    }

    /**
     * Identificacion del usuario.
     *
     * @param identificacion Identificacion
     */    
    public void setIdentificacion(final Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * getIp.
     * @return String
     */    
    public String getIp() {
        return ip;
    }

    /**
     * setIp.
     * @param ip IP del usuario
     */    
    public void setIp(final String ip) {
        this.ip = ip;
    }

    /**
     * Retorna el codigo de transaccion.
     * @return Codigo de transaccion.
     */    
    public String getTransaccion() {
        return transaccion;
    }        
        
}
