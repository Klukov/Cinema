package com.PiotrKlukowski.Cinema.exception;

public class SeatIncorrectnessException extends CinemaException {

    private static final String MESSAGE = "There cannot be single free seat between booked seats";

    public SeatIncorrectnessException() {
        super(MESSAGE);
    }

    public SeatIncorrectnessException(String message) {
        super(message);
    }
}
