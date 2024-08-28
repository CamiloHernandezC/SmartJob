package com.camilo.usermicroservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

/**
 *
 * @author camilo.hernandez
 *
 */
@Configuration
public class SwaggerConfig {

    private static final String MAINTAINER = "camilo.hernandez.castillo@gmail.com";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api Documentation")
                        .description("This module is in charge of CRUD operations for users")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Camilo Hernandez")
                                .email(MAINTAINER)
                        ))
                .addServersItem(new Server().url("/"));
    }

}
