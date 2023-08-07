package arquitectura.apicatalogapi.infrastructure.webservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            // Map creado para almacenar los tags para añadirlos una vez se hayan recorrido
            // todos los endpoints
            Map<String, Tag> tags = new HashMap<>();

			for (Endpoint endpoint : app.getEndpoints()) {
				endpoint.setAplicacion(app);

                for (Tag tag : endpoint.getTags()) {
                    tag.setAplicacion(app);

                    // Si el nombre no existe en el map lo añadimos, si no, no lo añadimos para no
                    // repetir nombres
                    if (!tags.containsKey(tag.getNombre())) {
                        tag.setAplicacion(app);
                        tags.put(tag.getNombre(), tag);
                    }
                }
			}
            List<Tag> tagList = new ArrayList<>(tags.values());
            app.setTags(tagList);
		}

		repository.saveAll(aplicaciones);
	}
}