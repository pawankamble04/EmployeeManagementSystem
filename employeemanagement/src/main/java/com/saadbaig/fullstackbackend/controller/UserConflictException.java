package com.saadbaig.fullstackbackend.controller;

public class UserConflictException extends RuntimeException {

    public UserConflictException(String message) {
        super(message);
    }
}
