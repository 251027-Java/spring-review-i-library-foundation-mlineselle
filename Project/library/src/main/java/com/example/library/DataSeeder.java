package com.example.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Component
public class DataSeeder implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            seedBooks();
        }
    }

    private void seedBooks() {
        bookRepository.save(new Book("Clean Code", "Robert Martin", null));
        bookRepository.save(new Book("The Pragmatic Programmer", "David Thomas", null));
        bookRepository.save(new Book("Design Patterns", "Gang of Four", null));
        bookRepository.save(new Book("Effective Java", "Joshua Bloch", null));
        bookRepository.save(new Book("Spring in Action", "Craig Walls", null));
    }
}
