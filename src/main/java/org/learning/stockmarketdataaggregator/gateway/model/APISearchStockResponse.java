package org.learning.stockmarketdataaggregator.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APISearchStockResponse {

    private List<APISearchStockMatch> bestMatches;
}
