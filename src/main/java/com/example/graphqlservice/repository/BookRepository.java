package com.example.graphqlservice.repository;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.graphqlservice.domain.Author;
import com.example.graphqlservice.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    public Set<Author> findAuthorsById(String id);

}
