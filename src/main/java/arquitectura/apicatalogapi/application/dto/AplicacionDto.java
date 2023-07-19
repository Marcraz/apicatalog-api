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
public class AplicacionDto {

	@NotNull
	@JsonProperty(value = "version")
	private String version;

	@NotNull
	@JsonProperty(value = "nombre")
	private String nombre;

	@NotNull
	@JsonProperty(value = "endpoints")
	private List<EndpointDto> endpoints;
}
