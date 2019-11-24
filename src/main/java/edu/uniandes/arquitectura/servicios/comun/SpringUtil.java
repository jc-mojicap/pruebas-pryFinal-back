package edu.uniandes.arquitectura.servicios.comun;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import edu.uniandes.arquitectura.servicios.comun.dto.Paginacion;

/**
 * Clase utilitaráa que utiliza componentes de Spring.
 * 
 */
public class SpringUtil {
    
    public static Pageable toPageable(Integer firstResult, Integer maxResults,  String[] strOrderBy , Boolean orderDesc){
        Direction direction = orderDesc ? Direction.DESC:  Direction.ASC;
        Sort sort = new Sort(direction, strOrderBy);
        Pageable pageable = new PageRequest(firstResult, maxResults, sort);
        return pageable;
    }
    
    public static Pageable toPageable(Paginacion paginacion){
        Direction direction = paginacion.isOrderDesc() ? Direction.DESC:  Direction.ASC;
        Sort sort = new Sort(direction, paginacion.getStrOrderBy());
        Pageable pageable = new PageRequest(paginacion.getFirstResult(), paginacion.getMaxResults(), sort);
        return pageable;
    }

}
