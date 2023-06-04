package arquitectura.apicatalogapi.infrastructure.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;
import arquitectura.apicatalogapi.infrastructure.webservice.clients.MockServerClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aplicaciones")
@RequiredArgsConstructor
public class AplicacionesController {
	
	@Autowired
	private final MockServerClient client;
	
	@GetMapping
	public ResponseEntity<List<AplicacionDto>> getAll(){
		return new ResponseEntity<>(client.getAplicaciones(), HttpStatus.OK);
	}
}
