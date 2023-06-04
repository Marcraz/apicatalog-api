package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import org.springframework.validation.annotation.Validated;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Validated
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class AplicacionDto {

    private String version;
	
    private String nombre;
	
    private List<EndpointDto> endpoints;
    
    private List<TagDto> tags;

}
