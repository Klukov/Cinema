package com.PiotrKlukowski.Cinema.exception;


public class NotFoundException extends CinemaException {

    private static final String DEFAULT_MESSAGE = "Specific record does not exist in the database";

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
