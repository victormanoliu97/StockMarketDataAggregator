package org.learning.stockmarketdataaggregator.gateway;

import lombok.RequiredArgsConstructor;
import org.learning.stockmarketdataaggregator.config.AlphaVantageProperties;
import org.learning.stockmarketdataaggregator.gateway.model.APISearchStockResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class AlphaVantageGateway {

    private final RestTemplate defaultRestTemplate;
    private final AlphaVantageProperties alphaVantageProperties;

    public APISearchStockResponse searchStock(String symbol) {
        UriBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(alphaVantageProperties.getUrl())
                .queryParam("function", "SYMBOL_SEARCH")
                .queryParam("keywords", symbol)
                .queryParam("apikey", alphaVantageProperties.getApiKey());

        ResponseEntity<APISearchStockResponse> responseEntity = defaultRestTemplate.getForEntity(uriBuilder.toUriString(), APISearchStockResponse.class);
        return responseEntity.getBody();
    }
}
