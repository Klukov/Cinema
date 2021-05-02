package com.PiotrKlukowski.Cinema.api.v1.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.SeatResponseModel;
import com.PiotrKlukowski.Cinema.model.Ticket;

public class SeatResponseConverter {

    public static SeatResponseModel convert(Ticket ticket) {
        return new SeatResponseModel(
                ticket.getId(),
                ticket.getRow(),
                ticket.getColumn(),
                ticket.getSeatType().name(),
                ticket.getTicketStatus().name());
    }
}
