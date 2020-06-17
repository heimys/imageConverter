package com.jalasoft.practice.model.converter.exception;

public class InvalidDataException extends Exception {
    private static final String MESSAGE = "Invalid Data";

    public InvalidDataException(Throwable ex) {
        super(MESSAGE, ex);
    }
}
