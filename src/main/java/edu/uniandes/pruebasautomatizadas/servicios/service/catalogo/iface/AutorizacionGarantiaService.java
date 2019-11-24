package edu.uniandes.pruebasautomatizadas.servicios.service.catalogo.iface;

import java.util.ArrayList;
import java.util.List;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.AutorizacionGarantia;

public interface AutorizacionGarantiaService {

	public ArrayList<AutorizacionGarantia> autorizarGarantia(ArrayList<AutorizacionGarantia> listaAutorizacion) throws Exception;

	public List<AutorizacionGarantia> listarTodas();
}
