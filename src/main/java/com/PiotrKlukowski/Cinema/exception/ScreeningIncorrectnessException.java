package com.PiotrKlukowski.Cinema.exception;

public class ScreeningIncorrectnessException extends CinemaException {

    private static final String MESSAGE = "Screening with this ID doesn't exist";

    public ScreeningIncorrectnessException () {
        super(MESSAGE);
    }

    public ScreeningIncorrectnessException (String message) {
        super(message);
    }
}
