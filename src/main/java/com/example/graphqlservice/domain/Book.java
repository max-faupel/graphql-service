package com.example.graphqlservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Book {
    @Id
    private String id;
    private String name;
    private int pageCount;
    @ManyToOne
    private Author author;

    public Book(String id, String name, int pageCount, Author author) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.author = Author.builder().id(author.getId()).firstName(author.getFirstName())
                .lastName(author.getLastName()).build();
    }
}