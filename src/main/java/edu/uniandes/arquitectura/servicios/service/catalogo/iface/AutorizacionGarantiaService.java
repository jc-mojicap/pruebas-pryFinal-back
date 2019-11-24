package edu.uniandes.arquitectura.servicios.service.catalogo.iface;

import java.util.ArrayList;
import java.util.List;

import edu.uniandes.arquitectura.servicios.dao.model.AutorizacionGarantia;

public interface AutorizacionGarantiaService {

	public ArrayList<AutorizacionGarantia> autorizarGarantia(ArrayList<AutorizacionGarantia> listaAutorizacion) throws Exception;

	public List<AutorizacionGarantia> listarTodas();
}
