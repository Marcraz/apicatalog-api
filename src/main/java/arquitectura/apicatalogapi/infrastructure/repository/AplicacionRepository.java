package arquitectura.apicatalogapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arquitectura.apicatalogapi.domain.model.Aplicacion;

@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer> {

}
