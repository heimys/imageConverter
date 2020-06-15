package com.jalasoft.practice.model.converter.exception;

import java.io.FileNotFoundException;

public class ConvertException extends Exception {
    private static final String MESSAGE = "Error converting to PDF";

    public ConvertException(Throwable ex) {
        super(MESSAGE, ex);
    }
}
