package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.request.model.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.OrderResponseModel;

public interface OrderService {

    OrderResponseModel createOrder(OrderRequestModel order);

    boolean cancelOrder(String orderId);
}
