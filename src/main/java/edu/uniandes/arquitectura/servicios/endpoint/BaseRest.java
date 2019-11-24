package edu.uniandes.arquitectura.servicios.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.uniandes.arquitectura.servicios.comun.RequestScope;

/**
 * Clase padre con metodos utilitarios.
 * Todos los controladores rest deben heredar de esta clase.
 */
public class BaseRest {   
       
    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * RequestScope que permite almacenar la identificacion del usuario de cada
     * peticion.
     */
    @Autowired
    protected RequestScope requestScope;

    /**
     * Contexto de la aplicacion
     */
    @Value("${server.contextPath}")
    protected String CONTEXTO;
    
    /**
     * Permite convertir las excepciones de tipo Exception en una respuesta JSON.
     * @param e Exception
     * @return Response
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response generalException(final Exception e) {
        String error = cadenaLogError(requestScope.getTransaccion(), e);
        log.error(error, e);        
        return Response.ERROR(error);
    }

    /**
     * Permite convertir las excepciones de tipo BadRequestException en una respuesta JSON.
     * @param e BadRequestException
     * @return Response
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response badRequestException(final BadRequestException e) {
        String error = cadenaLogError(requestScope.getTransaccion(), e);
        log.info(error, e); 
        return Response.ERROR(e.getMessage());
    }

    /**
     * Permite convertir las excepciones de tipo IllegalArgumentException en una respuesta
     * de tipo Bad Request (400).
     * @param e BadRequestException
     * @return Response
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response illegalArgumentException(final IllegalArgumentException e) {
        String error = cadenaLogError(requestScope.getTransaccion(), e);
        log.info(error, e); 
        return Response.ERROR(e.getMessage());
    }
    
    /**
     * Permite convertir las excepciones de tipo IllegalStateException en una respuesta
     * de tipo Bad Request (400).
     * @param e BadRequestException
     * @return Response
     */
    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Response illegalStateException(final IllegalStateException e) {
        String error = cadenaLogError(requestScope.getTransaccion(), e);
        log.info(error, e); 
        return Response.ERROR(e.getMessage());
    }
    
    /**
     * Permite convertir las excepciones de tipo ForbiddenException en una respuesta JSON.
     * @param e ForbiddenException
     * @return Response
     */
    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public Response forbiddenException(final ForbiddenException e) {
        String error = cadenaLogError(requestScope.getTransaccion(), e);
        log.info(error, e); 
        return Response.ERROR(e.getMessage());
    }
    
    /**
     * Contenido de la cadena a almacenar en el mensaje del log.
     *
     * @param codigo Codigo unico de error
     * @param t Throwable
     * @return Cadena con mensaje de log
     */
    private static String cadenaLogError(final String codigo, final Throwable t) {
        return String.format("%s, %s, %s", codigo, t.getClass().getName(), t.getMessage());
    }

}
