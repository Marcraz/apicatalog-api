package arquitectura.apicatalogapi.application.service;

import java.util.List;
import java.util.Optional;

import arquitectura.apicatalogapi.domain.model.Tag;

public interface TagService {
    List<Tag> getAllTags();

    Optional<Tag> getTagById(int id);

    void delete(int id);

    Tag create(Tag tag, Integer idAplicacion, List<Integer> idEndpoints);

    Tag create(Tag tag, Integer idAplicacion);

    Tag update(int id, Tag tag);
}
