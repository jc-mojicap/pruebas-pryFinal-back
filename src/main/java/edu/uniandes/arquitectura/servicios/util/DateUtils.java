package edu.uniandes.arquitectura.servicios.util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase utilitaria para fechas.
 * 
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final long MILLSECS_PER_HOUR = 60 * 60 * 1000;
    private static final long MILLSECS_PER_MINUTE = 60 * 1000;

    /**
     * Obtiene la diferencia de días entre 2 fechas.
     *
     * @param fecha1
     * @param fecha2
     * @return La cantidad de días que hay desde la fecha inicial hasta la fecha.
     * final. Si la fecha final es menor a la inicial, se devuelve la cantidad
     * de días en negativo.
     */
    public static int obtenerDiferenciaDias(Date fecha1, Date fecha2) {
        if (fecha1 == null) {
            fecha1 = new Date();
            fecha1.setTime(0);
        }
        if (fecha2 == null) {
            fecha2 = new Date();
            fecha1.setTime(0);
        }
        double diferencia = (fecha2.getTime() - fecha1.getTime()) / MILLSECS_PER_DAY;
        return new BigDecimal(diferencia).setScale(0, RoundingMode.DOWN).intValue();
    }

    /**
     * Obtiene la diferencia de días entre 2 fechas.
     *
     * @param fecha1
     * @param fecha2
     * @return La cantidad de días que hay desde la fecha inicial hasta la fecha.
     * final. Si la fecha final es menor a la inicial, se devuelve la cantidad
     * de días en negativo.
     */
    public static int obtenerDiferenciaDiasSinHora(Date fecha1, Date fecha2) {
        if (fecha1 == null) {
            fecha1 = new Date();
            fecha1.setTime(0);
        }
        if (fecha2 == null) {
            fecha2 = new Date();
            fecha1.setTime(0);
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(fecha1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(fecha2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        double diferencia = (cal2.getTime().getTime() - cal1.getTime().getTime()) / MILLSECS_PER_DAY;
        return new BigDecimal(diferencia).setScale(0, RoundingMode.DOWN).intValue();
    }

    /**
     * Obtiene la diferencia de horas entre 2 fechas.
     *
     * @param fecha1
     * @param fecha2
     * @return La cantidad de horas que hay desde la fecha inicial hasta la
     * fecha final. Si la fecha final es menor a la inicial, se devuelve la
     * cantidad de horas en negativo.
     */
    public static int obtenerDiferenciaHoras(Date fecha1, Date fecha2) {
        if (fecha1 == null) {
            fecha1 = new Date();
            fecha1.setTime(0);
        }
        if (fecha2 == null) {
            fecha2 = new Date();
            fecha2.setTime(0);
        }
        double diferencia = (fecha2.getTime() - fecha1.getTime()) / MILLSECS_PER_HOUR;
        return new BigDecimal(diferencia).setScale(0, RoundingMode.DOWN).intValue();
    }

    /**
     * Obtiene la diferencia de minutos entre 2 fechas.
     *
     * @param fecha1
     * @param fecha2
     * @return La cantidad de minutos que hay desde la fecha inicial hasta la
     * fecha final. Si la fecha final es menor a la inicial, se devuelve la
     * cantidad de minutos en negativo.
     */
    public static int obtenerDiferenciaMinutos(Date fecha1, Date fecha2) {
        if (fecha1 == null) {
            fecha1 = new Date();
            fecha1.setTime(0);
        }
        if (fecha2 == null) {
            fecha2 = new Date();
            fecha1.setTime(0);
        }
        double diferencia = (fecha2.getTime() - fecha1.getTime()) / MILLSECS_PER_MINUTE;
        return new BigDecimal(diferencia).setScale(0, RoundingMode.DOWN).intValue();
    }

    /**
     * obtenerDiferenciaMeses.
     * @param fecha1
     * @param fecha2
     * @return int
     */
    public static int obtenerDiferenciaMeses(Date fecha1, Date fecha2) {
        Calendar f1 = Calendar.getInstance();
        f1.setTime(fecha1);
        Calendar f2 = Calendar.getInstance();
        f2.setTime(fecha2);
        int m1 = f1.get(Calendar.YEAR) * 12 + f1.get(Calendar.MONTH);
        int m2 = f2.get(Calendar.YEAR) * 12 + f2.get(Calendar.MONTH);
        return m2 - m1;
    }

    /**
     * agregarDiasLaborales.
     * @param fecha1
     * @param dias
     * @return Date
     */
    public static Date agregarDiasLaborales(Date fecha1, int dias) {
        Calendar f1 = Calendar.getInstance();
        f1.setTime(fecha1);
        for (int i = 0; i < dias; i++) {
            if (f1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || f1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                i--;
            }
            f1.add(Calendar.DATE, 1);
        }
        return f1.getTime();
    }

    /**
     * formatDate.
     * @param date
     * @param format
     * @return String
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("es"));
        return dateFormat.format(date);
    }

    /**
     * formatDate.
     * @param date
     * @param format
     * @return Date
     */
    public static Date formatDate(String date, String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format, new Locale("es"));
            return dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * anioEsBisiesto.
     * @param date
     * @return boolean
     */
    public static boolean anioEsBisiesto(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return anioEsBisiesto(c.get(Calendar.YEAR));
    }

    /**
     * anioEsBisiesto.
     * @param year
     * @return boolean
     */
    public static boolean anioEsBisiesto(int year) {
        return (year % 4 == 0 && ((year % 100 != 0) || year % 400 == 0));
    }

    /**
     * isFechaValida.
     * @param format
     * @param fecha
     * @return boolean
     */
    public static boolean isFechaValida(String format, String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(format, new Locale("es"));
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * convertFecha.
     * @param format
     * @param date
     * @return Date
     * @throws ParseException
     */
    public static Date convertFecha(String format, String date) throws ParseException {
        DateFormat formatoDelTexto = new SimpleDateFormat(format, new Locale("es"));
        try {
            Date fechaD = (Date) formatoDelTexto.parse(date);
            return fechaD;
        } catch (ParseException e) {
            Logger.getLogger(DateUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     * getEdadPersona.
     * @param fechaNacimiento
     * @return int
     */
    public static int getEdadPersona(Date fechaNacimiento) {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int factor = 0;
        Date currentDate = new Date(); //current date
        birth.setTime(fechaNacimiento);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (birth.get(Calendar.DATE) > today.get(Calendar.DATE)) {
                    factor = -1;
                }
            } else {
                factor = -1;
            }
        }
        int age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
    }

    /**
     * getDiferenciaAnio.
     * @param fecha1
     * @param fecha2
     * @return int
     */
    public static int getDiferenciaAnio(Date fecha1, Date fecha2) {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int factor = 0;
        birth.setTime(fecha1);
        today.setTime(fecha2);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                    factor = -1;
                }
            } else {
                factor = -1;
            }
        }
        int age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
    }

    /**
     * validarFechaAnioMes.
     * @param fechaUpdate
     * @param fechaRadicacion
     * @return boolean
     */ 
    public static boolean validarFechaAnioMes(Date fechaUpdate, Date fechaRadicacion) {
        Calendar calendarUpdate = Calendar.getInstance();
        Calendar calendarActual = Calendar.getInstance();
        calendarUpdate.setTime(fechaUpdate);
        calendarActual.setTime(fechaRadicacion);

        if (calendarUpdate.get(Calendar.YEAR) != calendarActual.get(Calendar.YEAR)) {
            return false;
        }

        int mesActualizacion = calendarUpdate.get(Calendar.MONTH) + 1;
        int mesActual = calendarActual.get(Calendar.MONTH) + 1;

        return mesActualizacion != mesActual;
    }

    /**
     * isFechaValidaActual
     * @param fecha
     * @return boolean
     */
    public static boolean isFechaValidaActual(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            formatoFecha.setLenient(false);
            Date dt = formatoFecha.parse(fecha);
            if (dt.after(Calendar.getInstance().getTime())) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}