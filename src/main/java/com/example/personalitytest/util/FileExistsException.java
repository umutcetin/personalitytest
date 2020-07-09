package com.example.personalitytest.util;

@SuppressWarnings("serial")
public class FileExistsException extends Exception {
    public FileExistsException(String message) {
        super(message);
    }
}