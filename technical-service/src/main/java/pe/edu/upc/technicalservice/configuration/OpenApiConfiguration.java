package pe.edu.upc.technicalservice.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "technicalOpenApi")
    public OpenAPI technicalOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                .title("Technical Application API")
                .description(
                        "Technical API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0"));

    }

}
