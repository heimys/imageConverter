package com.jalasoft.practice;

import com.jalasoft.practice.controller.HelloController;
import com.jalasoft.practice.storage.StorageProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        SpringApplication.run(Main.class, args);
    }
}