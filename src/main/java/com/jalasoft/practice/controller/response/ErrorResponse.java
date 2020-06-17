package com.jalasoft.practice.controller.response;

public class ErrorResponse<T> extends Response<T>{
    String error;

    public ErrorResponse(String error, T status) {
        super(status);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}