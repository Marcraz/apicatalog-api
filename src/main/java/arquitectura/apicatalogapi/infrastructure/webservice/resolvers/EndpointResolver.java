package arquitectura.apicatalogapi.infrastructure.webservice.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.EndpointServiceImp;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class EndpointResolver implements GraphQLQueryResolver {

    @Autowired
    private EndpointServiceImp service;

    public List<Endpoint> getAllEndpoints() {
        return this.service.getAllEndpoints();
    }

    public Optional<Endpoint> getEndpointById(int id) {
        return this.service.getEndpointById(id);
    }
}
