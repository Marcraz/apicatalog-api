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
@EnableFeignClients
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

    private List<String> nombreTags = new ArrayList<>();

    private HashMap<String, Tag> tagMap = new HashMap<>();
    // private List<Tag> tagDatabase = tagRepository.findAll();
    //
    // private HashMap<String, Tag> tagMap = (HashMap<String, Tag>)
    // tagDatabase.stream()
    // .collect(Collectors.toMap(Tag::getNombre, Function.identity()));

    @Bean
    public CommandLineRunner commandLineRunnerBean(final SpringBootAdminClient spbClient,
            final ApiDocsClient adClient) throws FeignException {

        final var apps = spbClient.getApplications();

        for (final var app : apps) {
            try {
                ApiDoc apiDocs = adClient
                        .getApiDoc(URI.create(app.getInstances().get(0).getRegistration().getServiceUrl()));

                fillTagHashMap(apiDocs);
            } catch (final Exception e) {

            }
        }

        for (final var app : apps) {
            try {
                ApiDoc apiDocs = adClient
                        .getApiDoc(URI.create(app.getInstances().get(0).getRegistration().getServiceUrl()));
                fillDataBase(app.getName(), app.getBuildVersion(),
                        app.getInstances().get(0).getRegistration().getServiceUrl(), apiDocs);
            } catch (final Exception e) {

            }

        }
        return null;
    }

    private void fillDataBase(final String appName, final String appVersion, final String appBaseUrl,
            final ApiDoc apiDocs) {

        Aplicacion aplicacion = Aplicacion.builder().nombre(appName).version(appVersion).build();

        aplicacionRepository.save(aplicacion);

        List<Endpoint> endpoints = new ArrayList<>();


        for (final var pathEntry : apiDocs.getPaths().entrySet()) {

            // Ruta relativa del método
            final var path = pathEntry.getKey();

            // Iteramos sobre cada uno de los métodos de esa ruta (GET, POST, DELETE...)
            for (final var methodEntry : pathEntry.getValue().entrySet()) {

                final var operation = methodEntry.getKey();

                final Method method = methodEntry.getValue();

                String nombreTag = method.getTags().get(0);

                List<Endpoint> tagEndpoints = new ArrayList<>();

                List<Tag> tags = new ArrayList<>();

                Endpoint endpoint = Endpoint.builder().nombre(path).url(appBaseUrl)
                        .nombreOp(method.getOperationId()).tipoOP(operation).aplicacion(aplicacion).build();
                endpoints.add(endpoint);

                if (tagMap.containsKey(nombreTag)) {
                    Tag tag = tagMap.get(nombreTag);
                    tagEndpoints = tag.getEndpoints();

                    tagEndpoints.add(endpoint);
                    tag.setEndpoints(tagEndpoints);
                    endpoint.setTags(tags);
                    endpointRepository.save(endpoint);
                    addTagToApp(tag, aplicacion);
                } else {
                    tagEndpoints.add(endpoint);
                    Tag tagNuevo = Tag.builder().nombre(nombreTag).aplicacion(aplicacion).endpoints(tagEndpoints)
                            .build();
                    tagMap.put(nombreTag, tagNuevo);
                    endpoint.setTags(tags);
                    tagRepository.save(tagNuevo);
                    addTagToApp(tagNuevo, aplicacion);
                }

            }
        }
        aplicacion.setEndpoints(endpoints);
        aplicacionRepository.save(aplicacion);
    }

    private void fillTagHashMap(final ApiDoc apiDocs) {

        for (final var pathEntry : apiDocs.getPaths().entrySet()) {
            for (final var methodEntry : pathEntry.getValue().entrySet()) {

                final Method method = methodEntry.getValue();
                String nombreTag = method.getTags().get(0);
                nombreTags.add(nombreTag);
            }
        }
        List<Tag> tags = tagRepository.findByNombreIn(nombreTags);

        tagMap = (HashMap<String, Tag>) tags.stream().collect(Collectors.toMap(Tag::getNombre, Function.identity()));
    }

    private void addTagToApp(Tag tag, Aplicacion aplicacion) {
        List<Tag> tagsAplicacion = aplicacion.getTags();
        if (tagsAplicacion.contains(tag)) {
            tagsAplicacion.add(tag);
            aplicacion.setTags(tagsAplicacion);
        }
    }
}
