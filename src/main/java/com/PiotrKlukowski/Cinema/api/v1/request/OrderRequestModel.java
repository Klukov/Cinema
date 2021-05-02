package com.PiotrKlukowski.Cinema.api.v1.request;

import com.PiotrKlukowski.Cinema.typeList.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
public class OrderRequestModel {

    @Size(min = 1)
    private final Set<TicketRequestModel> tickets;

    private final String discountCode;

    @NotNull
    private final Currency currency;

    @NotNull
    private final BuyerRequestModel buyer;
}
