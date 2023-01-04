package com.example.graphqlservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlservice.domain.Author;
import com.example.graphqlservice.domain.Book;
import com.example.graphqlservice.repository.AuthorRepository;
import com.example.graphqlservice.repository.BookRepository;

@Controller
public class BookController {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    public Book bookById(@Argument String id) throws ResourceNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found! id=" + id));
    }

    @SchemaMapping
    public Author author(Book book) throws ResourceNotFoundException {
        return authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found! id=" + book.getAuthor().getId()));
    }
}
