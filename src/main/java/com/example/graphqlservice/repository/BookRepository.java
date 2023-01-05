package com.example.graphqlservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.graphqlservice.domain.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    
}
