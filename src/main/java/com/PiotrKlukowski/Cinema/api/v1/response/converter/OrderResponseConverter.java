package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.OrderResponseModel;
import com.PiotrKlukowski.Cinema.model.Reservation;

import java.util.stream.Collectors;

public class OrderResponseConverter {

    public static OrderResponseModel convert(Reservation order) {
        return new OrderResponseModel(
                order.getId(),
                order.getFinalPrice(),
                order.getFinalPriceCurrency(),
                order.getTickets().stream().map(SeatResponseConverter::convert).collect(Collectors.toSet())
        );
    }
}
