package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

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

	@NotNull
	@JsonProperty(value = "nombre")
	private String nombre;
	
	@NotNull
	@JsonProperty(value = "url")
    private String url;
    
	@NotNull
	@JsonProperty(value = "tipoOP")
    private String tipoOP;
    
	@NotNull
	@JsonProperty(value = "nombreOp")
    private String nombreOp;
	
	@NotNull
	@JsonProperty(value = "tags")
    private List<TagDto> tags;

}