package com.zex.ecommerce.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API")
                        .description("E-commerce rest API , developed to simulate a real super " +
                                "market, when you can buy products and assemble orders.")
                        .contact(new Contact()
                                .name("Jeliton Soares")
                                .email("jelitonn.soarres@gmail.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("http://ecommerce/api/license")))
                .addServersItem(new Server()
                        .url("https://e-commerce-api-production-3c7f.up.railway.app"))
                .addServersItem((new Server()
                        .url("http://localhost:8080")));
    }
}
