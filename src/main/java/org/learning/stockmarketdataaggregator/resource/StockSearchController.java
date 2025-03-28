package org.learning.stockmarketdataaggregator.resource;

import lombok.RequiredArgsConstructor;
import org.learning.stockmarketdataaggregator.model.SearchStockResponse;
import org.learning.stockmarketdataaggregator.service.StockSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/stock/search")
@RequiredArgsConstructor
public class StockSearchController {

    private final StockSearchService stockSearchService;

    @GetMapping("/{symbol}")
    public ResponseEntity<List<SearchStockResponse>> searchStock(@PathVariable String symbol) {
        return ResponseEntity.ok(stockSearchService.searchStock(symbol));
    }
}
