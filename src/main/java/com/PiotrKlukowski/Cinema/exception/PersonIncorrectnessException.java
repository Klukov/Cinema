package com.PiotrKlukowski.Cinema.exception;

public class PersonIncorrectnessException extends CinemaException {
    private static final String MESSAGE = "Incorrect Person Data";

    public PersonIncorrectnessException () {
        super(MESSAGE);
    }

    public PersonIncorrectnessException (String message) {
        super(message);
    }
}
