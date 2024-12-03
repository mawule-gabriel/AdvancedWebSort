package org.example.advancedwebsort.service;

import org.example.advancedwebsort.model.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Service for managing books, including retrieving all books or fetching a book by its ID.
 */
public class BookService {


    private final List<Book> books = Arrays.asList(
            new Book(1L, "1984", "George Orwell"),
            new Book(2L, "Brave New World", "Aldous Huxley"),
            new Book(3L, "Fahrenheit 451", "Ray Bradbury")
    );

    /**
     * Retrieves all books.
     *
     * @return a list of all books.
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book.
     * @return an {@link Optional} containing the book if found, or empty if not.
     */
    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }
}
