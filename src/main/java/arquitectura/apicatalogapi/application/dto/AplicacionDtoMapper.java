package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import org.mapstruct.Mapper;

import arquitectura.apicatalogapi.domain.model.Aplicacion;

@Mapper (componentModel = "spring")
public interface AplicacionDtoMapper {

	AplicacionDto fromEnity(Aplicacion entity);
	
	Aplicacion fromDto(AplicacionDto dto);
	
	List<AplicacionDto> fromDtoList(List<Aplicacion> entities);
	
	List<Aplicacion> fromEntityList(List<AplicacionDto> dtos);
}
