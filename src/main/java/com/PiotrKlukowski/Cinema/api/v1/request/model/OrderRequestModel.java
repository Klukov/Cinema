package com.PiotrKlukowski.Cinema.api.v1.request.model;

import com.PiotrKlukowski.Cinema.typeList.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@Builder
public class OrderRequestModel {

    @Getter
    @Size(min = 1)
    private Set<TicketRequestModel> tickets;

    @Getter
    private String discountCode;

    @Getter
    @NotNull
    private Currency currency;

    @Getter
    @NotNull
    private BuyerRequestModel buyer;
}
