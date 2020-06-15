package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.controller.response.ErrorResponse;
import com.jalasoft.practice.controller.response.OKResponse;
import com.jalasoft.practice.model.converter.ConverterFactory;
import com.jalasoft.practice.model.converter.IConverter;
import com.jalasoft.practice.model.converter.exception.ConvertException;
import com.jalasoft.practice.model.converter.exception.InvalidDataException;
import com.jalasoft.practice.model.converter.parameter.ImageParam;
import com.jalasoft.practice.model.converter.parameter.Parameter;
import com.jalasoft.practice.model.converter.result.Result;
import com.jalasoft.practice.storage.StorageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/")
public class ConvertController {
    private StorageService storageService;

    public ConvertController(StorageService storageService) {
        this.storageService = storageService;
    }

    @RequestMapping("/convert")
    @PostMapping
    public ResponseEntity convert(@RequestParam("file") MultipartFile file) {
        String uri = null;
        try {
            String fileName = storageService.store(file);
            uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(fileName + ".pdf")
                    .toUriString();

            IConverter converter = ConverterFactory.create(ConverterFactory.IMAGE);
            String outDir = storageService.getOutputLocation().toString() + "\\";
            String name1 = storageService.getLocation() + "\\" + fileName;
            File newFile = new File(name1);
            Parameter param = new ImageParam(newFile, outDir);
            Result result = converter.convert(param);

            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(uri, HttpServletResponse.SC_OK)
            );
        } catch (InvalidDataException | ConvertException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        }
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    public ResponseEntity download(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        try {
            String filePathToBeServed = storageService.getOutputLocation() + "/" + fileName;
            File fileToDownload = new File(filePathToBeServed);
            InputStream inputStream = new FileInputStream(fileToDownload);
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
            inputStream.close();

            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(fileName, HttpServletResponse.SC_OK)
            );
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        }
    }
}