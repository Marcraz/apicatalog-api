package arquitectura.apicatalogapi.infrastructure.webservice.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.EndpointServiceImp;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class EndpointMutation implements GraphQLMutationResolver {

    @Autowired
    private EndpointServiceImp service;

    public Endpoint createEndpoint(Endpoint endpoint, Integer idAplicacion) {
        return this.service.create(endpoint, idAplicacion);
    }

    public boolean deleteEndpoint(int id) {
        this.service.delete(id);
        return true;
    }

    public Endpoint updateEndpoint(int id, Endpoint endpoint) {
        return this.service.update(id, endpoint);
    }
}
