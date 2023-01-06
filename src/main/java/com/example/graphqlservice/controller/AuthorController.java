package com.example.graphqlservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlservice.domain.Author;
import com.example.graphqlservice.repository.AuthorRepository;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public Author authorByName(@Argument AuthorInput authorInput) {
        return authorRepository.findByFirstNameAndLastName(authorInput.getFirstName(), authorInput.getLastName());
    }
}
