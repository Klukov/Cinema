package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.OrderResponseModel;
import com.PiotrKlukowski.Cinema.model.Reservation;

public class OrderResponseConverter {

    public static OrderResponseModel convert(Reservation order) {
        return new OrderResponseModel();
    }
}
