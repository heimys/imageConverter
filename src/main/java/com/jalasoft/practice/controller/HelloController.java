package com.jalasoft.practice.controller;

import com.jalasoft.practice.storage.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private StorageService storageService;

    public HelloController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public String sayHello(@RequestParam(value="name") String name,
                           @RequestParam(value="lastName") String lastName,
                           @RequestParam("file") MultipartFile file) {
        String fileName = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();
        return "Hello " + name + " " + lastName;
    }
}