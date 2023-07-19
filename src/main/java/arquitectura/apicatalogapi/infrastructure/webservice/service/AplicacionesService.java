package arquitectura.apicatalogapi.infrastructure.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;
import arquitectura.apicatalogapi.application.dto.AplicacionDtoMapper;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
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
	
	private AplicacionDtoMapper mapper;
	
	public List<AplicacionDto> getAplicaciones(){
		List<AplicacionDto> response = client.getAplicaciones();
		return response;
	}
	
	public void importarAplicacionesInDB() {
		
		List<Aplicacion> aplicaciones = mapper.fromEntityList(getAplicaciones()); 
		repository.saveAll(aplicaciones);
	}
}
