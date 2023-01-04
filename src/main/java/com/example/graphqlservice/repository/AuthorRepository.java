package com.example.graphqlservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphqlservice.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, String> {
    
}
