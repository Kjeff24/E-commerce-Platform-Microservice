package com.bexos.payment_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfig {
    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }
}
