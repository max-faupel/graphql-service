package com.example.graphqlservice.domain;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Getter
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;
    private int pageCount;
    @DBRef
    private Set<Author> authors;

    public Book(String id, String name, int pageCount, Set<Author> authors) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authors = authors.stream().collect(Collectors.toSet());
    }
}