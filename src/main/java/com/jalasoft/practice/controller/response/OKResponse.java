package com.jalasoft.practice.controller.response;

public class OKResponse<T> extends Response<T> {
    String message;

    public OKResponse(String message, T status) {
        super(status);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}