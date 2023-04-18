package com.example.responsetimeinterceptors.exception;


public class InvalidHeaderException extends RuntimeException{

    String message;

    public InvalidHeaderException(String message) {
        this.setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
