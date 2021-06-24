package com.PiotrKlukowski.Cinema.api.v1.response;

import com.PiotrKlukowski.Cinema.typeList.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
public class OrderResponseModel {

    @Getter
    private String id;

    @Getter
    private BigDecimal finalPrice;

    @Getter
    private Currency finalPriceCurrency;

    @Getter
    private Set<SeatResponseModel> seats;
}
