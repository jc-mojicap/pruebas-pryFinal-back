package edu.uniandes.pruebasautomatizadas.servicios.service.back.iface;

import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Herramienta;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface HerramientaService {

    Optional<Herramienta> buscarPorId(Long id);

    List<Herramienta> buscarTodas();

    Optional<Herramienta> buscarPorNombre(String nombre);

    List<Herramienta> buscarPorUsuario(Usuario usuario);

    Herramienta crearHerramienta(Herramienta herramienta);
}
