package com.example.graphqlservice.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document
@Getter
@Builder
@NoArgsConstructor
public class Book {
    @org.springframework.data.annotation.Id
    private String id;
    private String name;
    private int pageCount;
    @DBRef
    private Author author;

    public Book(String id, String name, int pageCount, Author author) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.author = Author.builder().id(author.getId()).firstName(author.getFirstName())
                .lastName(author.getLastName()).build();
    }
}