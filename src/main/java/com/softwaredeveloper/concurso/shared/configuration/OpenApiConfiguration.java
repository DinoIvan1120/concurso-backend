package com.softwaredeveloper.concurso.shared.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Value("${concurso.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI(){
        //Definir el servidor de desarrollo
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development Environment");

        //Informacion de contacto
        Contact contact = new Contact();
        contact.setEmail("dino_pv_15@hotmail.com");
        contact.setName("DinoIvan");
        contact.setUrl("https://www.DinoIvan.com");

        //Informacion general de la API
        Info info = new Info()
                .title("Hackathon")
                .version("1.0.0")
                .contact(contact)
                .description("Hackathon")
                .termsOfService("https://www.DinoIvan.com/terms");

        return new OpenAPI()
                .info(info);

    }
}
