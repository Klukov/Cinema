package com.PiotrKlukowski.Cinema.api.v1.request;

import com.PiotrKlukowski.Cinema.typeList.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Builder
@Getter
public class TicketRequestModel {

    @NotNull
    private final String ticketId;

    @NotNull
    private final TicketType ticketType;
}
