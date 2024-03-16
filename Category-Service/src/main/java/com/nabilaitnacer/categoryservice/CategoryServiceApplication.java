package com.nabilaitnacer.categoryservice;


import com.nabilaitnacer.categoryservice.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Category Service API Documentation",
                description = "Category Service API Documentation for Happoy MarketPlace  microservice",
                version = "v1",
                contact = @Contact(
                        name = "Nabil Aitnacer",
                        email = "nabil.aitnacer@gmail.com",
                        url = "www.linkedin.com/in/nabil-ait-nacer"
                )
        )
)
public class CategoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryServiceApplication.class, args);
    }


}
