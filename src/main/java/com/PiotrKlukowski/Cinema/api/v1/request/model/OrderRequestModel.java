package com.PiotrKlukowski.Cinema.api.v1.request.model;

import com.PiotrKlukowski.Cinema.typeList.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Validated
public class OrderRequestModel {
    @Getter
    @Setter
    @Size(min = 1)
    private Set<TicketRequestModel> tickets;

    @Getter
    @Setter
    private String discountCode;

    @Getter
    @Setter
    @NotNull
    private Currency currency;

    @Getter
    @Setter
    @NotNull
    private BuyerRequestModel buyer;
}
