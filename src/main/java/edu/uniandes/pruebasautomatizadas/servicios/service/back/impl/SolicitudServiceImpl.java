package edu.uniandes.pruebasautomatizadas.servicios.service.back.impl;

import com.google.gson.Gson;
import edu.uniandes.pruebasautomatizadas.servicios.dao.back.iface.SolicitudRepository;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Solicitud;
import edu.uniandes.pruebasautomatizadas.servicios.dao.model.Usuario;
import edu.uniandes.pruebasautomatizadas.servicios.service.back.iface.SolicitudService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    private AwsSqsUtilities awsSqsUtilities;

    @Override
    public Optional<Solicitud> buscarPorId(Long id) {
        Validate.notNull(id, "El parametro id no puede ser nulo.");
        Solicitud solicitud = solicitudRepository.findOne(id);
        return solicitud != null ? Optional.of(solicitud) : Optional.empty();
    }

    @Override
    public List<Solicitud> buscarTodas() {
        return solicitudRepository.findAll();
    }

    @Override
    public List<Solicitud> buscarPorUsuario(Usuario usuario) {
        return solicitudRepository.findAllByCreadoPor(usuario);
    }

    @Override
    public Solicitud crearSolicitud(Solicitud solicitud) {
        awsSqsUtilities = new AwsSqsUtilities();
        Gson gson = new Gson();
        Solicitud response = solicitudRepository.save(solicitud);
        Map<String, String> params = new HashMap<>();
        params.put("NombreAplicacion", solicitud.getPruebas().get(0).getAplicacion().getNombre());
        params.put("NombreHerramienta", solicitud.getHerramienta().getNombre());
        awsSqsUtilities.sendSQSMessage(params,  gson.toJson(response));
        return response;
    }

}
