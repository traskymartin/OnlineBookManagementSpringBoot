package com.trasky.onlineBookmanagementSystem.exception;

public class BookNotFoundException  extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
