package com.PiotrKlukowski.Cinema.service;

import com.PiotrKlukowski.Cinema.api.v1.request.model.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.OrderResponseModel;

public interface OrderService {

    OrderResponseModel createOrder(OrderRequestModel order);

    void cancelOrder(String orderId);
}
