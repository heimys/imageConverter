package com.jalasoft.practice.model.converter.parameter;

import com.jalasoft.practice.model.converter.exception.InvalidDataException;

import java.io.File;

public class ImageParam extends Parameter{

    private String outDir;

    public ImageParam(File inputFile, String outDir) {
        super(inputFile);
        this.outDir = outDir;
    }

    public String getOutDir() {
     return outDir;
    }

    @Override
    public void validate() throws InvalidDataException {

    }
}
