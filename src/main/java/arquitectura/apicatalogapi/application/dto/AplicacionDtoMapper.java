package arquitectura.apicatalogapi.application.dto;

import arquitectura.apicatalogapi.domain.model.Aplicacion;

public interface AplicacionDtoMapper {

	AplicacionDto fromEnity(Aplicacion entity);
	
	Aplicacion fromDto(AplicacionDto dto);
}
