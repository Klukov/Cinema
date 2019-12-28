package com.PiotrKlukowski.Cinema.exception;

public class EnumIncorrectnessException extends CinemaException {

    private static final String MESSAGE = "Incorrect code value for enum";

    public EnumIncorrectnessException() {
        super(MESSAGE);
    }

    public EnumIncorrectnessException(String message) {
        super(message);
    }
}
