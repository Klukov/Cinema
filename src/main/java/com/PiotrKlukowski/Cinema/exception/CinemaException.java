package com.PiotrKlukowski.Cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CinemaException extends ResponseStatusException {

    public CinemaException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }

    public CinemaException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
