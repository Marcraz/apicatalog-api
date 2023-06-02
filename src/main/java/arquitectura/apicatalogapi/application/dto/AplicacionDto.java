package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Validated
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class AplicacionDto {

	@JsonProperty(value = "nombre")
    private String version;
	
	@JsonProperty(value = "nombre")
    private String nombre;
	
    private List<EndpointDto> endpoints;
    
    private List<TagDto> tags;

}
