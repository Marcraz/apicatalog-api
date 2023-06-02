package arquitectura.apicatalogapi.application.dto;

import arquitectura.apicatalogapi.domain.model.Endpoint;

public interface EndpointDtoMapper {

	Endpoint fromDto(EndpointDto entity);
}
