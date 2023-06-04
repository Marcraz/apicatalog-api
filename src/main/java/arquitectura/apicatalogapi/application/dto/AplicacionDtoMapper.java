package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import arquitectura.apicatalogapi.domain.model.Aplicacion;

public interface AplicacionDtoMapper {

	AplicacionDto fromEnity(Aplicacion entity);
	
	Aplicacion fromDto(AplicacionDto dto);
	
	List<AplicacionDto> fromDtoList(List<Aplicacion> entities);
	
	List<Aplicacion> fromEntityList(List<AplicacionDto> dtos);
}
