package com.PiotrKlukowski.Cinema.exception;


import org.springframework.http.HttpStatus;

public class NotFoundException extends CinemaException {

    private static final String DEFAULT_MESSAGE = "Specific record does not exist in the database";

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, DEFAULT_MESSAGE);
    }
}
