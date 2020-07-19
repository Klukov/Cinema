package com.PiotrKlukowski.Cinema.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public final class ExceptionDecorator {

    private ExceptionDecorator() {}

    public static <T, R> R wrap(Function<T,R> function, T parameter) {
        try {
            return function.apply(parameter);
        } catch (CinemaException e) {
            log.info("Wrong request causing " + e.getClass() + " with message: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error: " + e.getClass() + " with message: " + e.getMessage() + " and stack trace: ");
            e.printStackTrace();
            throw new CinemaException("Unexpected system error");
        }
    }

    public static <T> T wrap(Supplier<T> function) {
        try {
            return function.get();
        } catch (CinemaException e) {
            log.info("Wrong request causing " + e.getClass() + " with message: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error: " + e.getClass() + " with message: " + e.getMessage() + " and stack trace: ");
            e.printStackTrace();
            throw new CinemaException("Unexpected system error");
        }
    }
}
