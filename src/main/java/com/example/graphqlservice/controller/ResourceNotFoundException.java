package com.example.graphqlservice.controller;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String s) {
        super(s);
    }
}