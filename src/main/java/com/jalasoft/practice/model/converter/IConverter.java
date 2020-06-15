package com.jalasoft.practice.model.converter;

import com.jalasoft.practice.model.converter.exception.ConvertException;
import com.jalasoft.practice.model.converter.exception.InvalidDataException;
import com.jalasoft.practice.model.converter.parameter.Parameter;
import com.jalasoft.practice.model.converter.result.Result;

public interface IConverter<T extends Parameter> {
    Result convert(T param) throws InvalidDataException, ConvertException;
}
