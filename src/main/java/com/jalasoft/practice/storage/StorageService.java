package com.jalasoft.practice.storage;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

public interface StorageService {

    void init();

    String store(MultipartFile file);
    Path getOutputLocation();
    Path getLocation();
}