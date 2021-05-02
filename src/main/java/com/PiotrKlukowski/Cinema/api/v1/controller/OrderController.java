package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.request.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.OrderResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

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
