package edu.uniandes.arquitectura.servicios.comun;

import org.apache.commons.lang3.Validate;

/**
 * Clase que utilitaria para manejo de validaciones que extiene a la clase
 * Validate de Apache Commong Lang3.
 *
 */
public class ValidateUtil extends Validate {
     
    /**
     * Valida que el objeto no sea nulo.     
     * @param object Objeto a validar
     * @return el mismo objeto a validar.
     * @throws IllegalArgumentException Si el objeto no es nulo.
     */
    public static <T extends Object> T notNull(T object) {        
        return notNull(object, "El objeto no puede ser nulo.");
    }
    
    /**
     * Valida que el objeto no sea nulo.     
     * @param object Objeto a validar
     * @param message Mensaje a retornar en caso de excepcion.
     * @return el mismo objeto a validar.
     * @throws IllegalArgumentException Si el objeto es nulo.
     */
    public static <T extends Object> T notNull(T object, String message) {
        if(object == null) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }
    /**
     * Valida que el objeto sea nulo.     
     * @param object Objeto a validar.
     * @return el mismo objeto a validar.
     * @throws IllegalArgumentException Si el objeto no es nulo.
     */
    public static <T extends Object> T isNull(T object) {        
        return isNull(object, "El objeto debe ser nulo.");
    }
    
    /**
     * Valida que el objeto sea nulo.     
     * @param object Objeto a validar.
     * @param message Mensaje a retornar en caso de excepcion.
     * @return el mismo objeto a validar.
     * @throws IllegalArgumentException Si el objeto no es nulo.
     */
    public static <T extends Object> T isNull(T object, String message) {
        if(object != null) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }
    /**
     * Valida que la cadena sea nula, vacia o con espacios en blanco.
     * @param object Cadena a validar.
     * @param message Mensaje a retornar en caso de excepcion.
     * @return La misma cadena a validar,
     * @throws IllegalArgumentException Si la cadena es no es nula o tiene 
     * un contenido diferente de espacios en blanco.
     */
    public static String isBlank(String object, String message) {
        if(object != null && !object.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }
    
    /**
     * Valida que la cadena sea nula, vacia o con espacios en blanco.
     * @param object Cadena a validar.
     * @return La misma cadena a validar.
     * @throws IllegalArgumentException Si la cadena es no es nula o tiene 
     * un contenido diferente de espacios en blanco.
     */
    public static String isBlank(String object) {
        return isBlank(object, "La cadena no puede ser nula ni vacia.");
    }
}
