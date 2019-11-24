package edu.uniandes.arquitectura.servicios.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Clase con funcinalidades utilitarias para los servicios.
 *
 */
public class Utils {

    public final static String RUTA_TEMP_SISTEMA = System.getProperty("java.io.tmpdir");
    
    public final static String ID_CUERPO_CORREO = "correoCuerpo";
    public final static String ID_SMTP_AUTH = "correoSmtpAuth";
    public final static String ID_SMTP_HOST = "correoSmtpHost";
    public final static String ID_SMTP_PORT = "correoSmtpPort";
    public final static String ID_SMTP_SSL = "correoSmtpSsl";
    public final static String ID_PASSWORD_CORREO = "correoUserPassword";
    public final static String ID_USER_NAME = "correoUserName";
    public final static String ID_ASUNTO_CORREO = "correoAsunto";
    
    /**
     * Codigos de error server
     */
    public final static String CODIGO_ERROR_EXCEPTION = "001";
    public final static String CODIGO_ERROR_IO_EXCEPTION = "002";
    public final static String CODIGO_ERROR_MESSAGING_EXCEPTION = "003"; // MessagingException
    public final static String CODIGO_ERROR_NULL_EXCEPTION = "004";
    public final static String CODIGO_ERROR_ESTADO_EXCEPTION = "005";
    public final static String CODIGO_ERROR_FILE_NOT_FOUND_EXCEPTION = "006";
    public final static String CODIGO_ERROR_ILLEGAL_ARGUMENT_EXCEPTION = "007";
    public final static String LLAVE_CODIGOS_ERROR_SERVER = "codeError";
    
    public final static String SEPARADOR_DIRECTORIOS = System.getProperty("file.separator").toString();
    
    /**
     * Convierte una imagen a bytes
     * 
     * @param stringPath
     *            Ruta de la imagen
     * @return
     * @throws IOException
     */
    public static byte[] obtenerBytesImagen(String stringPath) throws IOException  {
        File file = new File(stringPath);
        if (!file.exists()) {
            return null;
        }
        Path path = Paths.get(stringPath);
        return Files.readAllBytes(path);
    }

    public static boolean conteinsRegEx(String sequence, String regEx) {
        Pattern pattern = Pattern.compile(regEx);
        if (pattern.matcher(sequence).find()) {
            return true;
        } else {
            return false;
        }
    }

    public static String stringArrayToString(String[] arrayString, String separator) {
        String result = "";
        int count = 0;
        for (String str : arrayString) {
            if (count == arrayString.length - 1) {
                result += str;
            } else {
                result += str + separator;
            }
            count++;
        }
        return result;
    }

    public static int countCharInString(char caracter, String cadena) {
        int cant = 0;
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            if (caracter == caracteres[i]) {
                cant++;
            }
        }
        return cant;
    }

    public static void agregarCeldaNumeroExcel(Row celda, int nroCelda, Number contenido) {
        @SuppressWarnings("deprecation")
        Cell celCodEnt = celda.createCell(nroCelda, Cell.CELL_TYPE_NUMERIC);
        celCodEnt.setCellValue(contenido != null ? contenido.doubleValue() : 0);
    }

    public static void agregarCeldaExcel(Row celda, int nroCelda, String contenido) {
        @SuppressWarnings("deprecation")
        Cell celCodEnt = celda.createCell(nroCelda, Cell.CELL_TYPE_STRING);
        HSSFRichTextString txtCodEntidad = new HSSFRichTextString(contenido);
        celCodEnt.setCellValue(txtCodEntidad);
    }
    
}
