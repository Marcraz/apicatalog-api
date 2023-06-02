package arquitectura.apicatalogapi.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arquitectura.apicatalogapi.domain.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Optional<Tag> findByNombre(String nombre);

    List<Tag> findByNombreIn(List<String> nombres);
}
