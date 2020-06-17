package com.jalasoft.practice.model.converter;

import com.jalasoft.practice.model.converter.exception.ConvertException;
import com.jalasoft.practice.model.converter.exception.InvalidDataException;
import com.jalasoft.practice.model.converter.parameter.ImageParam;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ImageToPdfConverterTest {

    private static final String PATH = "src/test/resources/image/";
    private static final String OUTDIR_PATH = "src/test/resources/pdf/";

    @Test
    public void convertImageToPdf() throws InvalidDataException, ConvertException {
        ImageToPdfConverter imageToPdfConverter = new ImageToPdfConverter();
        ImageParam param = new ImageParam(new File(PATH + "snake.png"), OUTDIR_PATH);
        assertEquals("test.pdf", imageToPdfConverter.convert(param).getName());
    }
}
