package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Aplicacion;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface AplicacionService {

    Optional<Aplicacion> buscarPorId(Long id);

    List<Aplicacion> buscarTodas();

    List<Aplicacion> buscarPorUsuario(Usuario usuario);
}
