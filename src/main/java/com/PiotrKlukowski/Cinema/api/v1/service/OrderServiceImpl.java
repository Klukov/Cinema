package com.PiotrKlukowski.Cinema.api.v1.service;


import com.PiotrKlukowski.Cinema.api.v1.request.OrderRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.converter.OrderResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.OrderResponseModel;
import com.PiotrKlukowski.Cinema.exception.IncorrectRequestDataException;
import com.PiotrKlukowski.Cinema.exception.NotFoundException;
import com.PiotrKlukowski.Cinema.model.Buyer;
import com.PiotrKlukowski.Cinema.model.Reservation;
import com.PiotrKlukowski.Cinema.model.Ticket;
import com.PiotrKlukowski.Cinema.repository.OrderRepository;
import com.PiotrKlukowski.Cinema.repository.TicketRepository;
import com.PiotrKlukowski.Cinema.typeList.Discount;
import com.PiotrKlukowski.Cinema.typeList.TicketStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final TicketRepository ticketRepository;

    public OrderServiceImpl(OrderRepository orderRepository, TicketRepository ticketRepository) {
        this.orderRepository = orderRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public OrderResponseModel createOrder(OrderRequestModel orderRequestModel) {
        Reservation order = new Reservation();
        orderRequestModel.getTickets().forEach(ticketRequestModel -> {
            Ticket ticket = ticketRepository.findById(ticketRequestModel.getTicketId())
                    .orElseThrow(() -> new IncorrectRequestDataException("At least one seat does not exist"));
            if (!ticket.getTicketStatus().equals(TicketStatus.FREE)) {
                throw new IncorrectRequestDataException("At least one seat is already booked");
            }
            ticket.setTicketStatus(TicketStatus.BOOKED);
            order.addTicket(ticket);
        });
        order.setBuyer(Buyer.builder()
                .firstName(orderRequestModel.getBuyer().getFirstName())
                .secondName(orderRequestModel.getBuyer().getSecondName())
                .lastName(orderRequestModel.getBuyer().getLastName())
                .email(orderRequestModel.getBuyer().getEmail())
                .phoneNumber(orderRequestModel.getBuyer().getPhoneNumber())
                .build());
        if (orderRequestModel.getDiscountCode() != null) {
            order.setDiscountCode(Discount.getDiscountFromCode(orderRequestModel.getDiscountCode()).getCode());
        }
        order.setFinalPriceCurrency(orderRequestModel.getCurrency());
        return OrderResponseConverter.convert(orderRepository.save(order));
    }

    @Override
    public void cancelOrder(String orderId) {
        Reservation order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order with id:" + orderId + "does not exist"));
        order.getTickets().forEach(ticket -> {
            ticket.setTicketType(null);
            ticket.setTicketStatus(TicketStatus.FREE);
            ticket.setReservation(null);
        });
        order.setTickets(new HashSet<>());
    }
}
