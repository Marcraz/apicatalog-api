package arquitectura.apicatalogapi.infrastructure.webservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;

@Component
public class MockServerClient {
	
	private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    
    @Autowired
    public MockServerClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    private final String mockServerUrl = "https://6b8198ea-7fc2-4848-9451-15eed1aff030.mock.pstmn.io/aplicacion";
    
    public AplicacionDto obtenerAplicacion() { // Reemplaza con la URL real de tu endpoint
        
        ResponseEntity<String> response = restTemplate.getForEntity(mockServerUrl, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                AplicacionDto aplicacionDto = objectMapper.readValue(response.getBody(), AplicacionDto.class);
                return aplicacionDto;
            } catch (JsonProcessingException e) {
                // Manejo de excepción en caso de error al deserializar el JSON
                e.printStackTrace();
            }
        }
        
        return null; // Manejo de otros casos de respuesta (error, sin contenido, etc.)
    }
}
