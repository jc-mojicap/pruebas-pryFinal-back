package edu.uniandes.arquitectura.servicios.comun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Clase utilitaria para funciones con fechas y horas.
 */
public final class DateTimeUtil {
    
    /**
     * Constructor privado. Esta clase no es instanceable.
     */
    private DateTimeUtil() {
        
    }
    
    /**
     * Retorna la fecha y hora actuales.
     * @param timezone Cadena con el timezone.
     * @return Cadena con la fecha y hora segun timezone.
     */
    public static String nowAsString(final String timezone) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        dt.setTimeZone(TimeZone.getTimeZone(timezone));
        return dt.format(new Date());
    }
}
