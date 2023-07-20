package arquitectura.apicatalogapi.infrastructure.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;
import arquitectura.apicatalogapi.application.dto.AplicacionDtoMapper;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import arquitectura.apicatalogapi.domain.model.Tag;
import arquitectura.apicatalogapi.infrastructure.repository.AplicacionRepository;
import arquitectura.apicatalogapi.infrastructure.webservice.clients.MockServerClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AplicacionesService {

	@Autowired
	private final MockServerClient client;

	@Autowired
	private AplicacionRepository repository;

	@Autowired
	private AplicacionDtoMapper mapper;

	public List<AplicacionDto> getAplicaciones() {
		return client.getAplicaciones();
	}

	public void importarAplicacionesInDB() {

		List<Aplicacion> aplicaciones = mapper.fromEntityList(getAplicaciones());

		for (Aplicacion app : aplicaciones) {
			for (Endpoint endpoint : app.getEndpoints()) {
				endpoint.setAplicacion(app);
				app.setTags(endpoint.getTags());

				for (Tag tag : endpoint.getTags()) {
					tag.setAplicacion(app);
				}
			}
		}

		repository.saveAll(aplicaciones);
	}
}