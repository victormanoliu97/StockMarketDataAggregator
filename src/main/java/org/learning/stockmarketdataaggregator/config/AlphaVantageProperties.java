package org.learning.stockmarketdataaggregator.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "vantage")
@Getter
@Setter
public class AlphaVantageProperties {

    private String url;
    private String apiKey;
}
