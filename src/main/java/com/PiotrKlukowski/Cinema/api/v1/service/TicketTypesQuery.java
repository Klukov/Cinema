package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.response.TicketTypeResponseModel;

import java.util.Set;

public interface TicketTypesQuery {
    Set<TicketTypeResponseModel> getAllTicketTypes();
}
