package org.learning.stockmarketdataaggregator.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate defaultRestTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMinutes(5))
                .setReadTimeout(Duration.ofMinutes(5))
                .build();
    }
}
