package com.jalasoft.practice.model.converter.parameter;

import com.jalasoft.practice.model.converter.exception.InvalidDataException;

import java.io.File;

public abstract class Parameter {
    protected File inputFile;

    public Parameter(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public abstract void validate() throws InvalidDataException;
}
