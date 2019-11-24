package edu.uniandes.arquitectura.servicios.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que añade funcionalidades a org.apache.commons.lang3.StringUtils
 *
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final Logger LOG = Logger.getLogger(StringUtils.class.getName());

    /**
     * Retorna la cadena entregada cambiando la primera letra por su equivalente
     * mayúscula
     *
     * @param str
     * @return
     */
    public static String firstCharToUpper(String str) {
        return capitalize(str);
    }

    /**
     * Retorna la cadena de caracteres con la primera letra de cada palabra en
     * mayúscula
     *
     * @param str
     * @return
     */
    public static String toUpperCamelCase(String str) {
        if (str == null) {
            return null;
        }

        StringBuilder ret = new StringBuilder();
        String[] split = str.split(" ");

        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {
                ret.append(firstCharToUpper(split[i].toLowerCase()));
            } else {
                ret.append(split[i].toLowerCase());
            }
            if (i != split.length - 1) {
                ret.append(" ");
            }
        }

        return ret.toString();
    }

    /**
     * Completa con ceros a la izquierda la cadena entregada hasta completar la
     * londigud requerida en el parámetro posiciones
     *
     * @param posiciones
     * @param numero
     * @return
     */
    public static String completarCeros(int posiciones, Number numero) {
        String rotuloCompleto = String.format("%0" + posiciones + "d", numero);
        return rotuloCompleto;

    }

    /**
     * Decodifica la cadena entregada a Base64
     *
     * @param cadena
     * @return
     */
    public static byte[] deCodificarBase64(String cadena) {
        // return Base64.decodeBase64(cadena);
        // http://migbase64.sourceforge.net/
        return Base64.decode(cadena);
    }

    /**
     * Codifica la cadena entregada a Base64
     *
     * @param data
     * @return
     */
    public static String codificarBase64(byte[] data) {
        // return Base64.encodeBase64String(data);
        return Base64.encodeToString(data, false);
    }

    /**
     * Devuelve la cadena entregada convirtiendo todas sus letras en mayúscula
     *
     * @param value
     * @return
     */
    public static String toUpper(String value) {
        return value != null ? value.toUpperCase() : value;
    }

    /**
     * Convierte todos los atributos de tipo String que se encuentren con valor
     * vacío ("") a NULL de la clase dada
     *
     * @param _class
     * @return
     */
    public <T> T cadenasVaciasANull(T _class) {
        Field[] i = _class.getClass().getFields();
        for (Field field : i) {
            try {
                if (field.getType().getName().equals(String.class.getName())
                        || field.getType().getName().equals(Character.class.getName())) {
                    Object obj = field.get(_class);
                    if (obj != null && obj.equals("")) {
                        field.set(_class, null);
                    }
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return (T) _class;
    }

    /**
     * Indica si el la representación de caracteres del objeto dado en vacía
     *
     * @param object
     * @return
     */
    public static boolean strNoEmpty(Object object) {
        return object != null && isNotBlank(String.valueOf(object));
    }

    /**
     * Verifica si el parámetro de entrada es nulo y retorna un String vacío en
     * caso de serlo
     *
     * @param value
     * @return El valor sin modificaciones si es diferente de null, en caso
     * contrario un String vacío.
     */
    public static String strToNotNull(String value) {
        return value != null ? value : "";
    }

    /**
     * Obtiene los numeros incluidos en una cadena de caracteres, se toman en
     * cuenta la notación científica
     *
     * @param value
     * @return
     */
    public static Number getNumber(String value) {
        if (value == null) {
            return 0;
        }
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
        String integer = "";
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i)) || value.charAt(i) == dfs.getDecimalSeparator()
                    || value.charAt(i) == dfs.getMinusSign()
                    || dfs.getExponentSeparator().equals(String.valueOf(value.charAt(i)))
                    || value.charAt(i) == dfs.getGroupingSeparator() || value.charAt(i) == dfs.getPatternSeparator()
                    || value.charAt(i) == dfs.getPercent()) {
                integer += value.charAt(i);
            }
        }
        if (strNoEmpty(integer)) {
            try {
                return new BigDecimal(integer);
            } catch (java.lang.NumberFormatException e) {
                LOG.log(Level.SEVERE, integer, e);
            }
        }
        return 0;
    }

    /**
     * Obtiene los caracteres no numéricos de una cadena dada
     *
     * @param value
     * @return
     */
    public static String getNoNumChars(String value) {
        if (value == null) {
            return null;
        }
        Pattern p = Pattern.compile("[\\d]");
        Matcher m = p.matcher(value);
        if (!m.find()) {
            return trim(value);
        }
        String string = "";
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                string += value.charAt(i);
            }
        }
        if (strNoEmpty(string)) {
            return trim(string);
        }
        return "";
    }

    /**
     * Prepara un string para recibir una cantidad N de parámetros en un query
     * JDBC
     *
     * @param length cantidad de parámetros que se van a ingresa
     * @return
     */
    public static String preparePlaceHolders(int length) {
        StringBuilder builder = new StringBuilder(length * 2 - 1);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append('?');
        }
        return builder.toString();
    }

    public static String formatName(String... nombresApellidos) {
        StringBuilder nombre = new StringBuilder();

        for (String string : nombresApellidos) {
            if (strNoEmpty(string)) {
                if (nombre.length() > 0) {
                    nombre.append(" ");
                }
                nombre.append(string);
            }
        }

        if (strNoEmpty(nombre.toString().trim())) {
            return toUpperCamelCase(nombre.toString());
        } else {
            return null;
        }

    }

    public static <T> String getStringCommaSparated(Collection<T> objs) {
        if (objs == null) {
            return null;
        }

        StringBuilder nombre = new StringBuilder();

        for (Object string : objs) {
            if (string != null && strNoEmpty(string.toString())) {
                if (nombre.length() > 0) {
                    nombre.append(", ");
                }
                nombre.append(string);
            }
        }

        if (strNoEmpty(nombre.toString().trim())) {
            return nombre.toString();
        } else {
            return null;
        }

    }

    public static <T> String getStringCommaSparated(T... objs) {
        if (objs == null) {
            return null;
        }

        StringBuilder nombre = new StringBuilder();

        for (Object string : objs) {
            if (string != null && strNoEmpty(string.toString())) {
                if (nombre.length() > 0) {
                    nombre.append(", ");
                }
                nombre.append(string);
            }
        }

        if (strNoEmpty(nombre.toString().trim())) {
            return nombre.toString();
        } else {
            return null;
        }

    }

    public static String encodingToHTML(String string) {
        if (string == null) {
            return string;
        }
        return string.replace("Á", "&Aacute;").replace("á", "&aacute;").replace("É", "&Eacute;")
                .replace("é", "&eacute;").replace("Í", "&Iacute;").replace("í", "&iacute;").replace("Ó", "&Oacute;")
                .replace("ó", "&oacute;").replace("Ú", "&Uacute;").replace("ú", "&uacute;").replace("Ü", "&Uuml;")
                .replace("ü", "&uuml;").replace("Ñ", "&Ntilde;").replace("ñ", "&ntilde;").replace("©", "&copy;")
                .replace("®", "&reg;").replace("¼", "&frac14;").replace("½", "&frac12;").replace("¾", "&frac34;")
                .replace("=", "&#61;").replace("/", "&#47;");
    }

    public static String encodingToUTF8(String string) {
        if (string == null) {
            return string;
        }
        string = string.replaceAll("Á", "\u00C1").replaceAll("á", "\u00E1").replaceAll("É", "\u00C9")
                .replaceAll("é", "\u00E9").replaceAll("Í", "\u00CD").replaceAll("í", "\u00ED").replaceAll("Ó", "\u00D3")
                .replaceAll("ó", "\u00F3").replaceAll("Ú", "\u00DA").replaceAll("ú", "\u00FA").replaceAll("Ü", "\u00DC")
                .replaceAll("ü", "\u00FC").replaceAll("ñ", "\u00F1").replaceAll("<", "\u003C").replaceAll(">", "\u003E")
                .replaceAll("í", "\u00ED").replaceAll("‘", "\u0027").replaceAll("©", "\u00A9").replaceAll("®", "\u00AE")
                .replaceAll("€", "\u20AC").replaceAll("¼", "\u00BC").replaceAll("½", "\u00BD")
                .replaceAll("¾", "\u00BE");
        try {
            return new String(string.getBytes("UTF-8"), ("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return string;
        }
    }

    public static String setNumberFormat(Number number, String pattern) {
        DecimalFormat nf = new DecimalFormat(pattern, DecimalFormatSymbols.getInstance(Locale.US));
        return nf.format(number);
    }

    public static String concatPath(String... path) {
        String concatPath = "";
        for (int i = 0; i < path.length; i++) {
            if (i > 0) {
                if (!concatPath.endsWith("/") && !concatPath.endsWith("\\") && !path[i].startsWith("/")
                        && !path[i].startsWith("\\")) {
                    path[i] = "/" + path[i];
                }
            }
            concatPath += path[i];
        }
        return concatPath;
    }

    public static String concatSystemPath(String... path) {
        String concatPath = "";
        for (int i = 0; i < path.length; i++) {
            if (i > 0) {
                if (!concatPath.endsWith("/") && !concatPath.endsWith("\\") && !path[i].startsWith("/")
                        && !path[i].startsWith("\\")) {
                    path[i] = System.getProperty("file.separator") + path[i];
                }
            }
            concatPath += path[i];
        }
        return concatPath;
    }

    public static int getWordCount(String string, String word) {
        int count = 0;
        if (word != null) {
            String sub = string;
            word = word + " ";
            while (containsIgnoreCase(sub, word)) {
                ++count;
                sub = sub.replaceFirst(word, " ");
            }
        }
        return count;
    }

    public static int getCharCount(String string, Character _char) {
        int count = 0;
        String sub = string;
        if (_char != null) {
            String new_char = String.valueOf(_char);
            while (containsIgnoreCase(sub, new_char)) {
                ++count;
                sub = sub.replaceFirst(new_char, " ");
            }
        }
        return count;
    }

    public static <T> String incluirParametros(String string, T... params) {
        if (string == null) {
            return "";
        }
        int i = 0;
        while (params != null && i < params.length) {
            if (params[i] != null) {
                string = string.replace("#" + i + "#", String.valueOf(params[i]));
            } else {
                string = string.replace("#" + i + "#", "");
            }
            i++;
        }
        return string.replaceAll("#([0-9]{1,2})#", "NULL");
    }

    public static String formatNumber(Number number) {
        return formatNumber(number, null, null);
    }

    public static String formatNumber(Number number, Locale locale) {
        return formatNumber(number, locale, null);
    }

    public static String formatNumber(Number number, String pattern) {
        return formatNumber(number, null, pattern);
    }

    public static String formatNumber(Number number, Locale locale, String pattern) {
        String str = "0";
        NumberFormat df = new DecimalFormat();
        if (locale != null && pattern != null) {
            df = new DecimalFormat(str, new DecimalFormatSymbols(locale));
        } else {
            if (locale != null) {
                df = DecimalFormat.getNumberInstance(locale);
            }
            if (pattern != null) {
                df = new DecimalFormat(str);
            }
        }
        str = df.format(number);
        return str;
    }

    public static boolean notEquals(CharSequence ch1, CharSequence ch2) {
        return !equals(ch1, ch2);
    }

    /**
     * Devuelve el primer valor no nulo y no vacío de la lista de string<br/>
     * Si ninguno cumple esta condición se devuelve una cadena vacía.
     *
     * @param string
     * @return
     */
    public static String coalesce(String... string) {
        if (string == null) {
            return null;
        }
        for (String str : string) {
            if (isNotBlank(str)) {
                return str;
            }
        }
        return "";
    }

    public static String firtsNonEspecialChars(String string, int size) {
        if (string == null) {
            return "";
        }
        return substring(Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^A-Za-z0-9]", ""), 0, size);
    }

    public static String removeAccents(String text) {
        if (text == null) {
            return text;
        }
        return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").trim();
    }

    public static String valueOf(Object valor) {
        if (valor == null) {
            return null;
        } else {
            return String.valueOf(valor);
        }
    }

    public static String concat(Object... strings) {
        if (strings == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static String concatWithSpace(Object... strings) {
        if (strings == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object string : strings) {
            sb.append(string).append(" ");
        }
        return sb.toString().trim();
    }

    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (isBlank(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while ((sb.length() > 0) && (sb.charAt(0) == leadingCharacter)) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * Convierte todos los atributos de tipo String y Character del objeto que
     * se encuentren vacíos a NULL
     *
     * @param objeto
     */
    public static void emptyStringToNull(Object objeto) {
        Field[] i = objeto.getClass().getDeclaredFields();
        for (Field field : i) {
            try {
                if (field.getType().getName().equals("java.lang.String")
                        || field.getType().getName().equals("java.lang.Character")) {
                    field.setAccessible(true);
                    if (field.get(objeto) != null && field.get(objeto).equals("")) {
                        field.set(objeto, null);
                    }
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, e.getMessage(), e);
            }
        }
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

    public static String[] splitString(String secuence, String splitRegEx, int length) {
        String[] strSplit = new String[length];
        int beginIndex = 0;
        int endIndex = 0;
        try {
            for (int i = 0; i < length; i++) {
                endIndex = secuence.indexOf(splitRegEx);
                if (endIndex == -1) {
                    endIndex = secuence.length();
                    strSplit[i] = secuence.substring(beginIndex, endIndex);
                } else {
                    strSplit[i] = secuence.substring(beginIndex, endIndex);
                    secuence = secuence.substring((endIndex + 1), secuence.length());
                }
                beginIndex = 0;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        return strSplit;
    }

    public static String completarEspacios(int posiciones, String cadena) {
        String rotuloCompleto = String.format("%" + posiciones + "s", cadena);
        return rotuloCompleto;
    }
    
    public static String getValorSinDecimal(String value) {
        if (value != null && !value.isEmpty()) {
            String [] val = value.split("\\.");
            value = val[0];
        }

        return value;
    }
    
}
