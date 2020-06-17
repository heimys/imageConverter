package com.jalasoft.practice.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    private String location;
    private String outputLocation;

    public String getLocation() {
        return location;
    }

    public String getOutputLocation() {
        return outputLocation;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }
}
