package arquitectura.apicatalogapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import arquitectura.apicatalogapi.infrastructure.webservice.service.AplicacionesService;



@SpringBootApplication
@EnableFeignClients
public class ApicatalogApiApplication implements CommandLineRunner{

	@Autowired
	AplicacionesService service;

    public static void main(String[] args) {
        SpringApplication.run(ApicatalogApiApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		service.importarAplicacionesInDB();
	}

   
}
