package edu.uniandes.arquitectura.servicios.endpoint;

/**
 * Excepcion que representa una peticion invalida.
 */
public class BadRequestException extends RuntimeException {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 3921570188030566658L;

    /**
     * Constructor.
     * @param message Mensaje de excepcion.
     */
    public BadRequestException(final String message) {
        super(message);
    }

}
