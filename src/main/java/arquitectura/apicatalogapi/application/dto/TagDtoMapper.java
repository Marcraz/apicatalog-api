package arquitectura.apicatalogapi.application.dto;

import arquitectura.apicatalogapi.domain.model.Tag;

public interface TagDtoMapper {
	
	Tag fromDto(TagDto tag);
}
