package com.informatica.hackathon.ShareKart.exception;

public class Violation {

    private String stackTrace;
    private String message;

    public Violation(String message) {
        this.message = message;
    }

    public Violation(String message, String stackTrace) {
        this.message = message;
        this.stackTrace = stackTrace;
    }

    public String getPropertyPath() {
        return stackTrace;
    }

    public void setPropertyPath(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
