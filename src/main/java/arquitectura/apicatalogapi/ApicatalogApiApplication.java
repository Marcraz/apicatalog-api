package arquitectura.apicatalogapi;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import arquitectura.apicatalogapi.application.dto.apidocs.ApiDoc;
import arquitectura.apicatalogapi.application.dto.apidocs.Method;
import arquitectura.apicatalogapi.domain.model.Aplicacion;
import arquitectura.apicatalogapi.domain.model.Endpoint;
import arquitectura.apicatalogapi.domain.model.Tag;
import arquitectura.apicatalogapi.infrastructure.repository.AplicacionRepository;
import arquitectura.apicatalogapi.infrastructure.repository.EndpointRepository;
import arquitectura.apicatalogapi.infrastructure.repository.TagRepository;
import arquitectura.apicatalogapi.infrastructure.service.ApiDocsClient;
import arquitectura.apicatalogapi.infrastructure.service.SpringBootAdminClient;
import feign.FeignException;

@SpringBootApplication
public class ApicatalogApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(ApicatalogApiApplication.class, args);
    }


    @Autowired
    private AplicacionRepository aplicacionRepository;

    @Autowired
    private EndpointRepository endpointRepository;

    @Autowired
    private TagRepository tagRepository;

   
}
