package arquitectura.apicatalogapi.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import arquitectura.apicatalogapi.application.service.AplicacionService;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import arquitectura.apicatalogapi.infrastructure.repository.AplicacionRepository;

@Service
public class AplicacionServiceImp implements AplicacionService {

    String message = "El ID no existe";

    @Autowired
    private AplicacionRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Aplicacion> getAllAplicaciones() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aplicacion> getAplicacionById(int id) {
        Optional<Aplicacion> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            return this.repository.findById(id);
        } else {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    @Transactional
    public Aplicacion create(Aplicacion aplicacion) {
        Aplicacion ap = new Aplicacion();
        ap.setNombre(aplicacion.getNombre());
        ap.setVersion(aplicacion.getVersion());

        return this.repository.save(ap);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Optional<Aplicacion> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            this.repository.deleteById(id);
        } else {
            throw new IllegalArgumentException(message);
        }

    }

    @Override
    @Transactional
    public Aplicacion update(int id, Aplicacion aplicacion) {
        aplicacion.setId(id);
        Optional<Aplicacion> entityExists = repository.findById(id);
        if (entityExists.isPresent()) {
            Aplicacion entity = entityExists.get();
            if(aplicacion.getNombre() != null) {
                entity.setNombre(aplicacion.getNombre());
            }
            if(aplicacion.getVersion() != null) {
                entity.setVersion(aplicacion.getVersion());
            }
            return this.repository.save(entity);
        } else {
            throw new IllegalArgumentException(message);
        }
    }
        
}


