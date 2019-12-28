package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.typeList.Currency;
import com.PiotrKlukowski.Cinema.typeList.TicketType;

public class TicketTypeResponseConverter {

    public static TicketTypeResponseModel convert(TicketType ticketType) {
        return new TicketTypeResponseModel(
                ticketType.name(),
                ticketType.getPriceByCurrency(Currency.PLN),
                ticketType.getPriceByCurrency(Currency.EUR),
                ticketType.getPriceByCurrency(Currency.USD));
    }
}
