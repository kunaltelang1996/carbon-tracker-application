package com.carbontracker.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Carbon Tracker API",
                version = "1.0",
                description = "APIs for tracking and managing carbon emissions"
        )
)
public class OpenApiConfig {
}
