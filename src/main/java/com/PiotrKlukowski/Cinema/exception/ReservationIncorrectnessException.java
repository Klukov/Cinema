package com.PiotrKlukowski.Cinema.exception;

public class ReservationIncorrectnessException extends CinemaException {
    private static final String MESSAGE = "Order cannot be processed";

    public ReservationIncorrectnessException() {
        super(MESSAGE);
    }

    public ReservationIncorrectnessException(String message) {
        super(message);
    }
}
