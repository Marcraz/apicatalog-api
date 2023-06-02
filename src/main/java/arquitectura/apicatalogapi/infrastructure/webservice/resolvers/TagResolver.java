package arquitectura.apicatalogapi.infrastructure.webservice.resolvers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.TagServiceImp;
import arquitectura.apicatalogapi.domain.model.Tag;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class TagResolver implements GraphQLQueryResolver {

    @Autowired
    private TagServiceImp service;

    public List<Tag> getAllTags() {
        return this.service.getAllTags();
    }

    public Optional<Tag> getTagById(int id) {
        return this.service.getTagById(id);
    }
}
