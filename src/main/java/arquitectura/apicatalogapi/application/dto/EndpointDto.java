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
public class EndpointDto {

	
	@JsonProperty(value = "nombre")
	private String nombre;
	
	@JsonProperty(value = "url")
    private String url;
    
	@JsonProperty(value = "tipoOP")
    private String tipoOP;
    
	@JsonProperty(value = "nombreOp")
    private String nombreOp;
    
    private AplicacionDto aplicacion;
    
    private List<TagDto> tags;

}