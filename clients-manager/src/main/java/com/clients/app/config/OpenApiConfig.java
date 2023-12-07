package com.clients.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
            title = "BANCO BCB",
                description = "MICROSERVICIO CLIENTE MANAGER",
                version = "0.0.1"
        )
)
public class OpenApiConfig {
    @Bean
    public OpenAPI customizeOpenAi(){
        final String securitName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitName))
                .components(new Components()
                        .addSecuritySchemes(securitName, new SecurityScheme()
                                .name(securitName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
