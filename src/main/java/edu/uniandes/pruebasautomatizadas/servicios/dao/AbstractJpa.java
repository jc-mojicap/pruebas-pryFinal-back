package edu.uniandes.pruebasautomatizadas.servicios.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase abstracta con metodos genericos implementados con JPA. 
 */
public abstract class AbstractJpa<T> {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * EntityManager.
     */
    @Autowired
    private EntityManager em;

    /**
     * Obtiene todos los registros de una entidad utilizando todos los filtros
     * (AND).
     *
     * @param filtros Map con el atributo de la entidad y el valor a filtrar.
     * @param clase Clase de la entidad.
     * @return Lista con los registros.
     */
    public List<T> findAll(final Map<String, String> filtros, final Class<T> clase) {
        boolean aplicarFiltros = true;
        StringBuilder consulta = new StringBuilder(
                String.format("SELECT e FROM %s e ", clase.getSimpleName()));
        if (filtros != null && !filtros.isEmpty()) {
            List<String> wheres = new ArrayList<>();
            for (String key : filtros.keySet()) {
                // Se valida que el filtro exista como atributo de la entidad
                Atributo attr = validarAtributo(clase, key, filtros.get(key));
                if (attr.isValido()) {
                    wheres.add(String.format("e.%s = :%s", attr.getNombre(), key));
                    aplicarFiltros &= aplicarFiltros;
                } else {
                    aplicarFiltros = false;
                }
            }
            if (aplicarFiltros) {
                consulta.append("WHERE ").append(StringUtils.join(wheres, " AND "));
            }
        }
        if (aplicarFiltros) {
            TypedQuery<T> query = em.createQuery(consulta.toString(), clase);
            for (String key : filtros.keySet()) {
                Atributo attr = validarAtributo(clase, key, filtros.get(key));
                query.setParameter(key, attr.getValor());
            }
            return query.getResultList();
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * Valida si el atributo pertenece a la clase y retorna el valor realizando
     * el casting necesario de acuerdo al tipo de dato del atributo.
     *
     * @param clase Clase.
     * @param atributo Atributo de la clase a validar.
     * @param valor Valor que contiene el atributo en formato de cadena de
     * caracteres.
     * @return Valor realizando el casting de acuerdo al tipo del atributo.
     */
    private Atributo validarAtributo(final Class clase, final String atributo, 
            final String valor) {
        try {
            for (Field field : clase.getDeclaredFields()) {
                if (field.getName().equals(atributo)) {
                    Object val = autoCast(field, valor);
                    if (val != null) {
                        return new Atributo(TipoAtributo.atributo, atributo, val);
                    } else {
                        for (Field fi : field.getType().getDeclaredFields()) {
                            if (fi.getAnnotation(Id.class) != null) {
                                return new Atributo(TipoAtributo.referencia,
                                        String.format("%s.%s", atributo, fi.getName()),
                                        autoCast(fi, valor));
                            }
                        }
                        log.info(String.format("El tipo de dato %s no ha sido configurado",
                                field.getType().getName()));
                        return new Atributo(TipoAtributo.invalido);
                    }
                }
            }
            return new Atributo(TipoAtributo.invalido);
        } catch (Exception ex) {
            // Si se presenta cualquier tipo de excepcion se retorna un optional vacio
            log.error(ex.getMessage(), ex);
            return new Atributo(TipoAtributo.invalido);
        }
    }

    /**
     * Retorna el valor haciendole casting teniendo en cuenta el tipo del parametro
     * field.
     * @param field Tipo de parametro a tener en cuenta.
     * @param valor Valor a convertir.
     * @return Objeto generico con casting.
     */
    private Object autoCast(final Field field, final String valor) {
        if (field.getType().getName().equals(String.class.getName())) {
            return valor;
        } else if (field.getType().getName().equals(Long.class.getName())) {
            return Long.valueOf(valor);
        } else if (field.getType().getName().equals(Double.class.getName())) {
            return Double.valueOf(valor);
        } else if (field.getType().getName().equals(Integer.class.getName())) {
            return Integer.valueOf(valor);
        } else if (field.getType().getName().equals(Float.class.getName())) {
            return Float.valueOf(valor);
        } else if (field.getType().getName().equals(Boolean.class.getName())) {
            return Boolean.valueOf(valor);
        } else {
            return null;
        }
    }

    /**
     * Clase que representa un atributo de un objeto.
     */
    private final class Atributo {
        /**
         * Tipo de atributo.
         */
        private final TipoAtributo tipoAtributo;
        /**
         * Nombre del atributo.
         */
        private final String nombre;
        /**
         * Contenido del atributo.
         */
        private final Object valor;

        /**
         * Constructor.
         * @param tipoAtributo Tipo de atributo.
         * @param nombre Nombre del atributo.
         * @param valor Valor del atributo.
         */
        Atributo(final TipoAtributo tipoAtributo, final String nombre, final Object valor) {
            this.tipoAtributo = tipoAtributo;
            this.nombre = nombre;
            this.valor = valor;
        }

        /**
         * Constructor.
         * @param tipoAtributo Tipo del atributo.
         */
        private Atributo(final TipoAtributo tipoAtributo) {
            this.tipoAtributo = tipoAtributo;
            this.nombre = "";
            this.valor = null;
        }

        /**
         * getTipoAtributo. 
         * @return TipoAtributo.
         */
        public TipoAtributo getTipoAtributo() {
            return tipoAtributo;
        }

        /**
         * getNombre.
         * @return String.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * getValor.
         * @return Object.
         */
        public Object getValor() {
            return valor;
        }

        /**
         * isValido.
         * @return True si es valido, de lo contrario false.
         */
        public boolean isValido() {
            return this.tipoAtributo != TipoAtributo.invalido;
        }
    }

    /**
     * Enumeracion con los tipos de atributo.
     */
    private enum TipoAtributo {
        atributo, referencia, invalido
    }
}
