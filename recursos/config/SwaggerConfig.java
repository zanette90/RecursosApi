package com.example.recursos.com.example.recursos.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API Gestão de Recursos")
                        .description("API para gerenciamento de recursos, reservas.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Alan Zanette Stefenon")
                                .email("alan.stefenon@live.com")
                                .url("https://github.com/zanette90"))
                        )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação completa")
                        .url("https://github.com/zanette90/recursos"));
    }
}