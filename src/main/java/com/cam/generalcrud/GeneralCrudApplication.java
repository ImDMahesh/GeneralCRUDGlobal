package com.cam.generalcrud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "v1"),
        servers = {@Server(url = "http://localhost:8080"), @Server(url = "http://oneone.com")}, tags = {@Tag(name = "Employee Operations", description = "This is employee operation API")}
)
@SecurityScheme(name = "BearerJWT", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT", description = "Bearer token for the project")
public class GeneralCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralCrudApplication.class, args);
    }
}
