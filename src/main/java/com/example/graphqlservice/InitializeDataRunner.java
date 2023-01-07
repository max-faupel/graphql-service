package com.example.graphqlservice;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.graphqlservice.domain.Author;
import com.example.graphqlservice.domain.Book;
import com.example.graphqlservice.repository.AuthorRepository;
import com.example.graphqlservice.repository.BookRepository;

@Component
public class InitializeDataRunner implements CommandLineRunner {
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

    @Override
    public void run(String... args) throws Exception {
        List<Author> authors = List.of(
                Author.builder().id("author-1").firstName("Joanne").lastName("Rowling").build(),
                Author.builder().id("author-2").firstName("Herman").lastName("Melville").build(),
                Author.builder().id("author-3").firstName("Anne").lastName("Rice").build());

        authorRepository.save(authors.get(0));
        authorRepository.save(authors.get(1));
        authorRepository.save(authors.get(2));

        bookRepository
                .save(new Book("book-1", "Harry Potter and the Philosopher's Stone", 223, Set.of(authors.get(0))));
        bookRepository.save(new Book("book-2", "Moby Dick", 635, Set.of(authors.get(1))));
        bookRepository.save(new Book("book-3", "Interview with the vampire", 371, Set.of(authors.get(2))));
    }

}
