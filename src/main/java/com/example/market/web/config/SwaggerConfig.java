package com.example.market.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "market",
                version = "1.0.0",
                description = "Market"
        )
)
public class SwaggerConfig {
}
