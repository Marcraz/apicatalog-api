package arquitectura.apicatalogapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arquitectura.apicatalogapi.domain.model.Endpoint;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint, Integer>{

}
