package com.nabilaitnacer.adsservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Ads Service API Documentation",
                description = "Ads Service API Documentation for Happoy MarketPlace  microservice",
                version = "v1",
                contact = @Contact(
                        name = "Nabil Ait nacer",
                        email = "nabil.aitnacer@gmail.com",
                        url = "www.linkedin.com/in/nabil-ait-nacer"
                )
        )
)
@EnableDiscoveryClient
@EnableFeignClients
public class AdsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsServiceApplication.class, args);
    }

}
