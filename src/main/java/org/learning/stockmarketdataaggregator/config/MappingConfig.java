package org.learning.stockmarketdataaggregator.config;

import org.learning.stockmarketdataaggregator.gateway.model.APISearchStockMatch;
import org.learning.stockmarketdataaggregator.model.SearchStockResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<APISearchStockMatch, SearchStockResponse>() {
            @Override
            protected void configure() {
                map(source.getSymbol(), destination.getSymbol());
                map(source.getName(), destination.getName());
                map(source.getType(), destination.getType());
                map(source.getRegion(), destination.getRegion());
                map(source.getCurrency(), destination.getCurrency());
                map(source.getMatchScore(), destination.getMatchScore());
            }
        });

        return modelMapper;
    }
}
