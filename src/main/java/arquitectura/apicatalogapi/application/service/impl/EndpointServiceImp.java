package arquitectura.apicatalogapi.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arquitectura.apicatalogapi.application.service.EndpointService;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import arquitectura.apicatalogapi.infrastructure.repository.EndpointRepository;

@Service
public class EndpointServiceImp implements EndpointService {

    String message = "El ID no existe";

    @Autowired
    private EndpointRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Endpoint> getAllEndpoints() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Endpoint> getEndpointById(int id) {
        Optional<Endpoint> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            return this.repository.findById(id);
        } else {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    @Transactional
    public Endpoint create(Endpoint endpoint, Integer idAplicacion) {
        endpoint.setAplicacion(new Aplicacion(idAplicacion));
        return this.repository.save(endpoint);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Endpoint> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            this.repository.deleteById(id);
        } else {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public Endpoint update(int id, Endpoint endpoint) {
        endpoint.setId(id);
        Optional<Endpoint> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            Endpoint entity = entityExists.get();
            if (endpoint.getNombre() != null) {
                entity.setNombre(endpoint.getNombre());
            }
            if (endpoint.getUrl() != null) {
                entity.setUrl(endpoint.getUrl());
            }
            if (endpoint.getNombreOp() != null) {
                entity.setNombreOp(endpoint.getNombreOp());
            }
            if (endpoint.getTipoOP() != null) {
                entity.setTipoOP(endpoint.getTipoOP());
            }
            return repository.save(entity);
        } else {
            throw new IllegalArgumentException(message);
        }
    }

}
