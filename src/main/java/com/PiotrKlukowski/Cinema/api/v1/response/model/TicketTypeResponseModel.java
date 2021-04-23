package com.PiotrKlukowski.Cinema.api.v1.response.model;

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
