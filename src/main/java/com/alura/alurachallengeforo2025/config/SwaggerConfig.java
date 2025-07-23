package com.alura.alurachallengeforo2025.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI foroAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST - Foro Alura Challenge 2025")
                        .description("Documentación de endpoints para foro con JWT y CRUDs")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("foro-api")
                .pathsToMatch("/**")
                .build();
    }
}
