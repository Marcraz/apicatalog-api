package arquitectura.apicatalogapi.application.service;

import java.util.List;
import java.util.Optional;

import arquitectura.apicatalogapi.domain.model.Aplicacion;

public interface AplicacionService {

    Aplicacion create(Aplicacion aplicacion);

    void delete(int id);

    Aplicacion update(int id, Aplicacion aplicacion);

    List<Aplicacion> getAllAplicaciones();

    Optional<Aplicacion> getAplicacionById(int id);
}
