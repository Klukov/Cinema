package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.request.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.OrderResponseModel;

public interface OrderService {

    OrderResponseModel createOrder(OrderRequestModel order);

    boolean cancelOrder(String orderId);
}
