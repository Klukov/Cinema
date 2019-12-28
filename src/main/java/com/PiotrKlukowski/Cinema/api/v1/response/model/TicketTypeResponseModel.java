package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeResponseModel {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private BigDecimal pricePLN;

    @Getter
    @Setter
    private BigDecimal priceEUR;

    @Getter
    @Setter
    private BigDecimal priceUSD;
}
