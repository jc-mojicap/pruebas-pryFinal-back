package edu.uniandes.arquitectura.servicios.endpoint;

/**
 * Excepcion que representa una peticion no autorizada.
 *
 */
public class ForbiddenException extends RuntimeException {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1030118343246197469L;

    /**
     * Constructor.
     * @param message Mensaje de la excepcion.
     */
    public ForbiddenException(final String message) {
        super(message);
    }
}
