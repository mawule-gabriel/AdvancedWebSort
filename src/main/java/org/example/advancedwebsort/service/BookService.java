package org.example.advancedwebsort.service;

import org.example.advancedwebsort.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookService {

    private final List<Book> books = Arrays.asList(
            new Book(1L, "1984", "George Orwell"),
            new Book(2L, "Brave New World", "Aldous Huxley"),
            new Book(3L, "Fahrenheit 451", "Ray Bradbury")
    );

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get book by id
    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
}
