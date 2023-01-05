package com.example.graphqlservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.graphqlservice.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
    
}
