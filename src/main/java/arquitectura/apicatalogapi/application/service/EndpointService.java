package arquitectura.apicatalogapi.application.service;

import java.util.List;
import java.util.Optional;

import arquitectura.apicatalogapi.domain.model.Endpoint;

public interface EndpointService {

    Endpoint create(Endpoint endpoint, Integer idAplicacion);

    List<Endpoint> getAllEndpoints();

    Optional<Endpoint> getEndpointById(int id);

    void delete(int id);

    Endpoint update(int id, Endpoint endpoint);

}
