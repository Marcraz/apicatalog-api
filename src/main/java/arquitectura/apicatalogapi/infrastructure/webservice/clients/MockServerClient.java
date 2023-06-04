package arquitectura.apicatalogapi.infrastructure.webservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import arquitectura.apicatalogapi.application.dto.AplicacionDto;
import arquitectura.apicatalogapi.infrastructure.webservice.configuration.FeignClientConfig;

@FeignClient(name="MOCK-SERVER-API", url="${external.mock.api.base-url}", configuration = FeignClientConfig.class)
public interface MockServerClient {

	@GetMapping(value = "/aplicaciones", consumes = MediaType.APPLICATION_JSON_VALUE)
	List<AplicacionDto> getAplicaciones();
}
