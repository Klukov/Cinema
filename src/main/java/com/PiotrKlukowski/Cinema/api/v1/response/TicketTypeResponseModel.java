package com.PiotrKlukowski.Cinema.api.v1.response;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class TicketTypeResponseModel {
    private String name;
    private BigDecimal pricePLN;
    private BigDecimal priceEUR;
    private BigDecimal priceUSD;
}
