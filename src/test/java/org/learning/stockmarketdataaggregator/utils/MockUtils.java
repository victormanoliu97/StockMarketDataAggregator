package org.learning.stockmarketdataaggregator.utils;

import lombok.experimental.UtilityClass;
import org.learning.stockmarketdataaggregator.gateway.model.APISearchStockMatch;
import org.learning.stockmarketdataaggregator.gateway.model.APISearchStockResponse;
import org.learning.stockmarketdataaggregator.model.SearchStockResponse;

import java.util.List;

@UtilityClass
public class MockUtils {

    public static APISearchStockResponse apiSearchStockResponse() {
        return APISearchStockResponse.builder()
                .bestMatches(List.of(
                        APISearchStockMatch.builder()
                                .symbol("IBM")
                                .name("International Business Machines Corp")
                                .type("Equity")
                                .region("United States")
                                .marketOpen("09:30")
                                .marketClose("16:00")
                                .timezone("UTC-04")
                                .currency("USD")
                                .matchScore("1.0000")
                                .build(),
                        APISearchStockMatch.builder()
                                .symbol("IBMN")
                                .name("ISHARES IBONDS DEC 2025 TERM MUNI BOND ETF")
                                .type("ETF")
                                .region("United States")
                                .marketOpen("09:30")
                                .marketClose("16:00")
                                .timezone("UTC-04")
                                .currency("USD")
                                .matchScore("0.8571")
                                .build()
                ))
                .build();
    }

    public static List<SearchStockResponse> searchStockResponse() {
        return List.of(
                SearchStockResponse.builder()
                        .symbol("IBM")
                        .name("International Business Machines Corp")
                        .type("Equity")
                        .region("United States")
                        .timezone("UTC-04")
                        .currency("USD")
                        .matchScore("1.0000")
                        .build(),
                SearchStockResponse.builder()
                        .symbol("IBMN")
                        .name("ISHARES IBONDS DEC 2025 TERM MUNI BOND ETF")
                        .type("ETF")
                        .region("United States")
                        .timezone("UTC-04")
                        .currency("USD")
                        .matchScore("0.8571")
                        .build()
        );
    }

    public static SearchStockResponse searchStockResponse1() {
        return SearchStockResponse.builder()
                .symbol("IBM")
                .name("International Business Machines Corp")
                .type("Equity")
                .region("United States")
                .timezone("UTC-04")
                .currency("USD")
                .matchScore("1.0000")
                .build();
    }

    public static SearchStockResponse searchStockResponse2() {
        return SearchStockResponse.builder()
                .symbol("IBMN")
                .name("ISHARES IBONDS DEC 2025 TERM MUNI BOND ETF")
                .type("ETF")
                .region("United States")
                .timezone("UTC-04")
                .currency("USD")
                .matchScore("0.8571")
                .build();
    }

}
