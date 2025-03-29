package org.learning.stockmarketdataaggregator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learning.stockmarketdataaggregator.gateway.AlphaVantageGateway;
import org.learning.stockmarketdataaggregator.model.SearchStockResponse;
import org.learning.stockmarketdataaggregator.utils.MockUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class StockSearchServiceTest {

    private static final String IBM_SYMBOL = "IBM";

    @Mock
    private AlphaVantageGateway alphaVantageGateway;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private StockSearchService stockSearchService;

    @Test
    @DisplayName("Search for stock test")
    void searchStockTest() {
        Mockito.when(alphaVantageGateway.searchStock(IBM_SYMBOL)).thenReturn(MockUtils.apiSearchStockResponse());
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(MockUtils.searchStockResponse1(), MockUtils.searchStockResponse2());

        List<SearchStockResponse> actualResults = stockSearchService.searchStock(IBM_SYMBOL);
        Assertions.assertNotNull(actualResults);
        Assertions.assertEquals(2, actualResults.size());
        Assertions.assertTrue(actualResults.containsAll(MockUtils.searchStockResponse()));
    }
}