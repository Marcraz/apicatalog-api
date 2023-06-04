package arquitectura.apicatalogapi.infrastructure.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;
import arquitectura.apicatalogapi.infrastructure.webservice.clients.MockServerClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AplicacionesService {

	@Autowired
	private final MockServerClient client;
	
	public List<AplicacionDto> getAplicaciones(){
		List<AplicacionDto> response = client.getAplicaciones();
		return response;
	}
}
