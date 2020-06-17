package com.jalasoft.practice.model.converter;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {
    public final static String IMAGE = "image";
    public final static String WORD = "word";
    public final static Map<String, IConverter> converters = new HashMap<String, IConverter>() {
        {
            put(IMAGE, new ImageToPdfConverter());
            // TODO: Implements WordToPdfConverter for required.
            // put(WORD, new WordToPdfConverter());
        }
    };

    public static IConverter create(String name){
        return converters.get(name);
    }
}
