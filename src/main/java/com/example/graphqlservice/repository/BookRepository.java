package com.example.graphqlservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.graphqlservice.domain.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    
}
