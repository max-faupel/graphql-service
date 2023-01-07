package com.example.graphqlservice.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.graphqlservice.domain.Author;
import com.example.graphqlservice.domain.Book;
import com.example.graphqlservice.input.AuthorInput;
import com.example.graphqlservice.input.CreateBookInput;
import com.example.graphqlservice.repository.AuthorRepository;
import com.example.graphqlservice.repository.BookRepository;

import jakarta.validation.Valid;

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

    @QueryMapping
    public Author authorByName(@Argument AuthorInput authorInput) {
        return authorRepository.findByFirstNameAndLastName(authorInput.getFirstName(), authorInput.getLastName());
    }

    @MutationMapping
    public Book createBook(@Valid @Argument CreateBookInput createBookInput) {
        Set<Author> authors = createBookInput.getAuthors().stream()
                .map(createAuthorInput -> authorRepository
                        .save(Author.builder().id(createAuthorInput.getId()).firstName(createAuthorInput.getFirstName())
                                .lastName(createAuthorInput.getLastName()).build()))
                .collect(Collectors.toSet());
        return bookRepository.save(
                new Book(createBookInput.getId(), createBookInput.getName(), createBookInput.getPageCount(), authors));
    }
}
