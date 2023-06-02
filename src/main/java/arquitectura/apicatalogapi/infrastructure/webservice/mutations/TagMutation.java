package arquitectura.apicatalogapi.infrastructure.webservice.mutations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arquitectura.apicatalogapi.application.service.impl.TagServiceImp;
import arquitectura.apicatalogapi.domain.model.Tag;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class TagMutation implements GraphQLMutationResolver {

    @Autowired
    private TagServiceImp service;

    public Tag createTag(Tag tag, Integer idAplicacion, List<Integer> listaEp) {
        return this.service.create(tag, idAplicacion, listaEp);
    }

    public Tag updateTag(int id, Tag tag) {
        return this.service.update(id, tag);
    }

    public boolean deleteTag(int id) {
        this.service.delete(id);
        return true;
    }
}
