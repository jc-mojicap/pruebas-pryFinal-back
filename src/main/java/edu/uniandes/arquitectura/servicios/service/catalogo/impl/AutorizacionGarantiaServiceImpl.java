package edu.uniandes.arquitectura.servicios.service.catalogo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.core.exceptions.WrongArgumentException;

import edu.uniandes.arquitectura.servicios.comun.ValidateUtil;
import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.AutorizacionGarantiaRepository;
import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.CompraRepository;
import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.EmpleadoRepository;
import edu.uniandes.arquitectura.servicios.dao.catalogo.iface.GarantiaRepository;
import edu.uniandes.arquitectura.servicios.dao.model.AutorizacionGarantia;
import edu.uniandes.arquitectura.servicios.dao.model.Empleado;
import edu.uniandes.arquitectura.servicios.dao.model.Garantia;
import edu.uniandes.arquitectura.servicios.service.catalogo.iface.AutorizacionGarantiaService;

/**
 * Implementacion de los servicios de negocio para el recurso Empresa.
 */
@Service
public class AutorizacionGarantiaServiceImpl implements AutorizacionGarantiaService {

	@Autowired
	private AutorizacionGarantiaRepository autorizacionGarantiaRepository;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private GarantiaRepository garantiaRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ArrayList<AutorizacionGarantia> autorizarGarantia(ArrayList<AutorizacionGarantia> listaAutorizacion) throws Exception{
		ArrayList<AutorizacionGarantia> listaResultante = new ArrayList<AutorizacionGarantia>();
		System.out.println("autorizarGarantia");
		ValidateUtil.notNull(listaAutorizacion, "El listado de autorizaciones no puede ser nulo");
		if (listaAutorizacion.size() > 0) {
			for (AutorizacionGarantia autorizacion : listaAutorizacion) {
				ValidateUtil.notNull(autorizacion.getIdAutorizacion(),
						"El parámetro id autorización no puede ser nulo.");
				ValidateUtil.notNull(autorizacion.getCodigoAutorizacion(),
						"El código de autorización no puede ser nulo.");

				AutorizacionGarantia anterior = autorizacionGarantiaRepository
						.findByIdAutorizacion(autorizacion.getIdAutorizacion());
				System.err.println("anterior " + anterior);

				if (anterior == null) {
					throw new IllegalArgumentException(
							String.format("No existe la entidad con id=%s", autorizacion.getIdAutorizacion()));
				} else {
					try {
						if (verificarVigenciaGarantia(autorizacion)){
							autorizacion.setFechaActualizacion(new Date());
							autorizacion.setFechaAutorizacion(new Date());
							autorizacion.setEstado("A");						
						} else {
							autorizacion.setFechaActualizacion(new Date());
							autorizacion.setFechaAutorizacion(new Date());
							autorizacion.setEstado("N");
							autorizacion.getGarantia().setObservaciones("El tiempo de garantia expiró");
						}
						
						System.err.println("-----------------------------");
						System.err.println("autorizacion " + autorizacion);
						listaResultante.add(autorizacionGarantiaRepository.save(autorizacion));						
					} catch (Exception e) {
						System.err.println("Error de datos" + e.getMessage());
					}
				}

			}
		} else {
			return null;
		}

		return listaResultante;
	}

	@Override
	public ArrayList<AutorizacionGarantia> listarTodas() {
		return (ArrayList<AutorizacionGarantia>) autorizacionGarantiaRepository.findAll();
	}
	
	private boolean verificarVigenciaGarantia(AutorizacionGarantia autorizacionGarantia) throws Exception{
		Date fechaActual = new Date();
		AutorizacionGarantia autorizacionGarantia2 = autorizacionGarantiaRepository.findOne(1L);
		System.err.println("**********************************************");
		System.out.println("autorizacionGarantia2 " + autorizacionGarantia2);
		autorizacionGarantia = autorizacionGarantiaRepository.findByIdAutorizacion(autorizacionGarantia.getIdAutorizacion());
		System.out.println("fechaActual " + fechaActual);
		System.out.println("autorizacionGarantia " + autorizacionGarantia);
//		System.out.println("autorizacionGarantia.getGarantia() " + autorizacionGarantia.getGarantia());
//		System.out.println("autorizacionGarantia.getGarantia() del repo " + garantiaRepository.findOne(1l));
//		System.out.println("autorizacionGarantia.getGarantia().getCarro() " + autorizacionGarantia.getGarantia().getCarro());
		Date fechaCompra = compraRepository.findByCarro(autorizacionGarantia.getGarantia().getCarro()).getFechaCompra();
//		Date fechaCompra = new Date();
		System.out.println("fechaCompra" + fechaCompra);
		if (fechaActual.before(fechaCompra)){
			throw new WrongArgumentException("La fecha de compra es superior a la fecha actual");
		}
		int dias = (int)((fechaActual.getTime()-fechaCompra.getTime())/60*60*24*1000);//segundos * minutos * horas * 1000 = milisegundos por día
		if (dias < autorizacionGarantia.getGarantia().getCarro().getAniosGarantia()*365){
			return true; //La garantia aun esta vigente
		}
		return false; //La garantia ya esta fuera del tiempo de vigencia
	}
}
