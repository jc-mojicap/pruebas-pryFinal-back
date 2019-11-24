package edu.uniandes.pruebasautomatizadas.servicios.comun;

/**
 * Identificacion del usuario autenticado por token.
 */
public class Identificacion {
    
    /**
     * Identificador del usuario.
     */
    private Integer id;

    /**
     * Constructor.
     * @param id Identificador del usuario.
     */
    public Identificacion(final Integer id) {
        this.id = id;
    }

    /**
     * Retorna el identificador del usuario.
     * @return Long
     */
    public Integer getId() {
        return id;
    }
    
    
}
