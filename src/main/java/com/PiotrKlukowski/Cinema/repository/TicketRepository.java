package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, String> {
}
