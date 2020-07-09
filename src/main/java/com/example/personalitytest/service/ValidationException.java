package com.example.personalitytest.service;

@SuppressWarnings("serial")
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}