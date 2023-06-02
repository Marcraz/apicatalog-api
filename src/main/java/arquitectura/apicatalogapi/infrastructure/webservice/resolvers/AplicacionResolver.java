package arquitectura.apicatalogapi.infrastructure.webservice.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.AplicacionServiceImp;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class AplicacionResolver implements GraphQLQueryResolver {

    @Autowired
    private AplicacionServiceImp service;

    public List<Aplicacion> getAllAplicaciones() {
        return this.service.getAllAplicaciones();
    }

    public Optional<Aplicacion> getAplicacionById(int id) {
        return this.service.getAplicacionById(id);
    }
}
