package edu.uniandes.pruebasautomatizadas.servicios.endpoint;

import java.io.Serializable;

/**
 * Clase que representa una respuesta generica.
 */
public class Response implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 385528334753803078L;
    /**
     * Respuesta correcta o incorrecta.
     */
    private final boolean success;
    /**
     * Mensaje de respuesta.
     */
    private final String message;

    /**
     * Constructor privadao. Esta clase no puede instancearse.
     * @param success Respuesta correcta o incorrecta.
     * @param message Mensaje de respuesta.
     */
    private Response(final boolean success, final String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * getSuccess.
     * @return boolean
     */
    public boolean getSuccess() {
        return success;
    }

    /**
     * getMessage.
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Permite instancear una respuesta correcta.
     * @param message Mensaje de la respuesta.
     * @return Response
     */
    public static Response SUCCESS(final String message) {
        return new Response(true, message);
    }

    /**
     * Permite instancear una respuesta incorrecta.
     * @param message Mensaje de la respuesta.
     * @return Response
     */
    public static Response ERROR(final String message) {
        return new Response(false, message);
    }
}
