package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.HerramientaRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Herramienta;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.HerramientaService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Override
    public Optional<Herramienta> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        Herramienta herramienta = herramientaRepository.findOne(id);
        return herramienta != null ? Optional.of(herramienta) : Optional.empty();
    }

    @Override
    public List<Herramienta> buscarTodas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Optional<Herramienta> buscarPorNombre(String nombre) {
        Herramienta herramienta = herramientaRepository.findByNombre(nombre);
        return herramienta != null ? Optional.of(herramienta) : Optional.empty();
    }

    @Override
    public List<Herramienta> buscarPorUsuario(Usuario usuario) {
        return herramientaRepository.findAllByCreadoPor(usuario);
    }

    @Override
    public Herramienta crearHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }
}
