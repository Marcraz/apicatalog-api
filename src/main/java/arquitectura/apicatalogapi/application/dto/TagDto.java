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
public class TagDto {

	private String nombre;
    private AplicacionDto aplicacion;
    private List<EndpointDto> endpoints;
}
