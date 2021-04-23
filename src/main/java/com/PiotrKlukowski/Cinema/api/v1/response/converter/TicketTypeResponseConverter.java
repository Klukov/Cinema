package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.typeList.Currency;
import com.PiotrKlukowski.Cinema.typeList.TicketType;

public class TicketTypeResponseConverter {

    public static TicketTypeResponseModel convert(TicketType ticketType) {
        return TicketTypeResponseModel.builder()
                .name(ticketType.name())
                .pricePLN(ticketType.getPriceByCurrency(Currency.PLN))
                .priceEUR(ticketType.getPriceByCurrency(Currency.EUR))
                .priceUSD(ticketType.getPriceByCurrency(Currency.USD))
                .build();
    }
}
