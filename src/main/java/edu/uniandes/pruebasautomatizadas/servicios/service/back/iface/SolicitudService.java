package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Solicitud;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {

    Optional<Solicitud> buscarPorId(Long id);

    List<Solicitud> buscarTodas();

    List<Solicitud> buscarPorUsuario(Usuario usuario);

    Solicitud crearSolicitud(Solicitud solicitud);
}
