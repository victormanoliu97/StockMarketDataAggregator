package org.learning.stockmarketdataaggregator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchStockResponse {

    private String symbol;
    private String name;
    private String type;
    private String region;
    private String timezone;
    private String currency;
    private String matchScore;
}
