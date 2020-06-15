package com.jalasoft.practice.controller.response;

public abstract class Response<T> {
    T status;

    public Response(T status) {
        this.status =  status;
    }

    public T getStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }
}