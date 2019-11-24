package edu.uniandes.pruebasautomatizadas.servicios.comun.dto;

import java.io.Serializable;

/**
 * DTO para la paginación del resultado de una consulta.
 */
public class Paginacion implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * firstResult.
     */
    private Integer firstResult;
    /**
     * maxResults.
     */
    private Integer maxResults;
    /**
     * orderBy.
     */
    private Integer[] orderBy;
    /**
     * strOrderBy.
     */
    private String[] strOrderBy;
    /**
     * orderDesc.
     */
    private boolean orderDesc;
    
    /**
     * Constructor.
     */
    public Paginacion(){
        
    } 
    
    /**
     * Constructor.
     * @param firstResult.
     * @param maxResults
     * @param orderBy.
     * @param orderDesc.
     */
    public Paginacion(Integer firstResult, Integer maxResults,  Integer[] orderBy , Boolean orderDesc){
        this.firstResult = firstResult;
        this.maxResults = maxResults;
        this.orderBy = orderBy;
        this.orderDesc = orderDesc;
    }
    
    /**
     * Constructor.
     * @param firstResult.
     * @param maxResults
     * @param strOrderBy.
     * @param orderDesc.
     */
    public Paginacion(Integer firstResult, Integer maxResults,  String[] strOrderBy , Boolean orderDesc){
        this.firstResult = firstResult;
        this.maxResults = maxResults;
        this.strOrderBy = strOrderBy;
        this.orderDesc = orderDesc;
    } 

    /**
     * @return the firstResult.
     */
    public Integer getFirstResult() {
        return firstResult;
    }

    /**
     * @param firstResult the firstResult to set.
     */
    public void setFirstResult(Integer firstResult) {
        this.firstResult = firstResult;
    }

    /**
     * @return the maxResults.
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * @param maxResults the maxResults to set.
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * @return the orderBy.
     */
    public Integer[] getOrderBy() {
        return orderBy;
    }

    /**
     * @param orderBy the orderBy to set.
     */
    public void setOrderBy(Integer... orderBy) {
        this.orderBy = orderBy;
    }
    
    /**
     * @return the getStrOrderBy.
     */
    public String[] getStrOrderBy() {
        return strOrderBy;
    }

    /**
     * @param strOrderBy the strOrderBy to set.
     */
    public void setStrOrderBy(String... strOrderBy) {
        this.strOrderBy = strOrderBy;
    }

    /**
     * @return the orderDesc.
     */
    public boolean isOrderDesc() {
        return orderDesc;
    }

    /**
     * @param orderDesc the orderDesc to set.
     */
    public void setOrderDesc(boolean orderDesc) {
        this.orderDesc = orderDesc;
    }
}