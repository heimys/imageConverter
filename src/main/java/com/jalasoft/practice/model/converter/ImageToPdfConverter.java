package com.jalasoft.practice.model.converter;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.jalasoft.practice.model.converter.exception.ConvertException;
import com.jalasoft.practice.model.converter.exception.InvalidDataException;
import com.jalasoft.practice.model.converter.parameter.ImageParam;
import com.jalasoft.practice.model.converter.result.Result;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

public class ImageToPdfConverter implements IConverter<ImageParam>{
    @Override
    public Result convert(ImageParam param) throws InvalidDataException, ConvertException {
        try {
            String outputFile = Paths.get(param.getOutDir(), param.getInputFile().getName() + ".pdf").toString();
            Document document=new Document();
            PdfWriter.getInstance(document,new FileOutputStream(outputFile));
            document.open();
            Image image = Image.getInstance (param.getInputFile().getAbsolutePath());
            document.add(new Paragraph(""));
            document.add(image);
            document.close();
            return new Result();

        } catch (FileNotFoundException e) {
            throw new ConvertException(e);
        } catch (MalformedURLException e) {
            throw new ConvertException(e);
        } catch (IOException e) {
            throw new ConvertException(e);
        } catch (BadElementException e) {
            throw new ConvertException(e);
        } catch (DocumentException e) {
            throw new ConvertException(e);
        }
    }
}
