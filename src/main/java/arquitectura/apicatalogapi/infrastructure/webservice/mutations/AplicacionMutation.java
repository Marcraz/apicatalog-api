package arquitectura.apicatalogapi.infrastructure.webservice.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.AplicacionServiceImp;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AplicacionMutation implements GraphQLMutationResolver {

    @Autowired
    private AplicacionServiceImp service;

    public Aplicacion createAplicacion(Aplicacion aplicacion) {
        return this.service.create(aplicacion);
    }

    public boolean deleteAplicacion(int id) {
        service.delete(id);
        return true;
    }

    public Aplicacion updateAplicacion(int id, Aplicacion apliacion) {
        return this.service.update(id, apliacion);
    }
}
