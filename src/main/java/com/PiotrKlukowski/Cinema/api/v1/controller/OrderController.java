package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.request.model.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.OrderResponseModel;
import com.PiotrKlukowski.Cinema.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
public class OrderController {

    private OrderService orderService;

    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("order")
    @Transactional
    public OrderResponseModel createOrder(@Valid @RequestBody OrderRequestModel orderRequestModel) {
        return orderService.createOrder(orderRequestModel);
    }

    @PostMapping("order/{orderId}/actions/cancel")
    @Transactional
    public void createOrder(@PathVariable String orderId) {
        orderService.cancelOrder(orderId);
    }
}
