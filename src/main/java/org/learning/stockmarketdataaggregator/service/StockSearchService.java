package org.learning.stockmarketdataaggregator.service;

import lombok.RequiredArgsConstructor;
import org.learning.stockmarketdataaggregator.gateway.AlphaVantageGateway;
import org.learning.stockmarketdataaggregator.gateway.model.APISearchStockResponse;
import org.learning.stockmarketdataaggregator.model.SearchStockResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockSearchService {

    private final AlphaVantageGateway alphaVantageGateway;
    private final ModelMapper modelMapper;

    public List<SearchStockResponse> searchStock(String symbol) {
        APISearchStockResponse apiResponse = alphaVantageGateway.searchStock(symbol);
        return apiResponse.getBestMatches()
                .stream()
                .map(s -> modelMapper.map(s, SearchStockResponse.class))
                .collect(Collectors.toList());
    }
}
