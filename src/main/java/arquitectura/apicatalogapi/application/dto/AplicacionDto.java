package arquitectura.apicatalogapi.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class AplicacionDto {

    private String name;

    private String buildVersion;

    private List<EndpointDto> instances;

}
