package com.PiotrKlukowski.Cinema.api.v1.request.model;

import com.PiotrKlukowski.Cinema.typeList.TicketType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestModel {

    @Getter
    @Setter
    private String ticketId;

    @Getter
    @Setter
    private TicketType ticketType;
}
