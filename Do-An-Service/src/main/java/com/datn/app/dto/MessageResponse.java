package com.datn.app.dto;

public class MessageResponse {
    int code;
    String message;

    public MessageResponse() { }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
