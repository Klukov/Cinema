package com.PiotrKlukowski.Cinema.exception;

public class InvalidRequestException extends CinemaException {

    private static final String MESSAGE = "Wrong parameters in query exception";

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException() {
        super(MESSAGE);
    }
}
