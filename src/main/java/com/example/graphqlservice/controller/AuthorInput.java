package com.example.graphqlservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorInput {
    private String firstName;
    private String lastName;
    
}
