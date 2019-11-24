package edu.uniandes.arquitectura.servicios.comun.dto;

import java.io.Serializable;

public class RespuestaServicio implements Serializable {
    
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * respuesta.
     */
    private String respuesta;
    /**
     * error.
     */
    private boolean error;
    
    /**
     * codigoError.
     */
    private String codigoError;
    
    /**
     * Constructor. 
     */
    public RespuestaServicio(){
        
    }
    
    /**
     * @param respuesta
     * @param error
     * @param codigoError
     * Constructor. 
     */
    public RespuestaServicio(String respuesta, boolean error, String codigoError){
        this.respuesta = respuesta;
        this.error = error;
        this.codigoError = codigoError;
    }
    
    /**
     * getRespuesta.
     * @return String.
     */
    public String getRespuesta() {
        return respuesta;
    }
    /**
     * setRespuesta.
     * @param respuesta.
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    /**
     * isError
     * @return boolean.
     */
    public boolean isError() {
        return error;
    }
    /**
     * setError.
     * @param error.
     */
    public void setError(boolean error) {
        this.error = error;
    }
    /**
     * getCodigoError.
     * @return String.
     */
    public String getCodigoError() {
        return codigoError;
    }
    /**
     * setCodigoError.
     * @param codigoError.
     */
    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

}
