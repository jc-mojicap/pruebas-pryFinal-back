package edu.uniandes.arquitectura.servicios.dao;

/**
 * Clase utilitaria para capa DAO.
 *
 */
public class DaoUtil {

    public static String generarOrderBy(Integer[] indicesCampos, boolean desc) {
        if (indicesCampos != null && indicesCampos.length > 0) {
            StringBuilder sb = new StringBuilder();
            if (indicesCampos.length > 0) {
                int count = 0;
                sb.append("ORDER BY ");
                if (indicesCampos.length == 1) {
                    sb.append(indicesCampos[0]);
                    count ++;
                } else {
                    int index = 0;
                    for (Integer indiceCampo : indicesCampos) {
                        if (indiceCampo != null) {
                            sb.append(indicesCampos[index]);
                            if (index < indicesCampos.length - 1) {
                                sb.append(", ");
                            }
                            count++;
                        }
                        index++;
                    }
                    if (sb.lastIndexOf(",") == sb.length() - 2) {
                        sb.replace(sb.length() - 2, sb.length() - 1, "");
                    }
                }
                if (desc) {
                    sb.append(" DESC ");
                } else {
                    sb.append(" ASC ");
                }
                if(count == 0){
                    sb.delete(0, sb.length()-1);
                }
            }
            return sb.toString();
        } else {
            return "";
        }
    }

}
