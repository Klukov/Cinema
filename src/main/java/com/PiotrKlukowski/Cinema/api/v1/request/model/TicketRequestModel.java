package com.PiotrKlukowski.Cinema.api.v1.request.model;

import com.PiotrKlukowski.Cinema.typeList.TicketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Builder
public class TicketRequestModel {

    @Getter
    @NotNull
    private String ticketId;

    @Getter
    @NotNull
    private TicketType ticketType;
}
