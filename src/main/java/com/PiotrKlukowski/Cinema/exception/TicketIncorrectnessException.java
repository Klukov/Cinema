package com.PiotrKlukowski.Cinema.exception;

public class TicketIncorrectnessException extends CinemaException {

    private static final String MESSAGE = "Ticket cannot be null and have proper data";

    public TicketIncorrectnessException() {
        super(MESSAGE);
    }

    public TicketIncorrectnessException(String message) {
        super(message);
    }
}
