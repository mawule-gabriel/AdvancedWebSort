package org.example.advancedwebsort.controller;

import org.example.advancedwebsort.service.BookService;
import org.example.advancedwebsort.model.Book;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

/**
 * REST controller for managing books with HATEOAS support.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService = new BookService();

    /**
     * Retrieves all books with self-links.
     *
     * @return a list of all books with added HATEOAS links.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        books.forEach(book -> {
            Link selfLink = linkTo(BookController.class).slash(book.getId()).withSelfRel();
            book.add(selfLink);
        });
        return books;
    }

    /**
     * Retrieves a book by its ID with a self-link.
     *
     * @param id the ID of the book to retrieve.
     * @return the book with the self-link.
     * @throws RuntimeException if the book is not found.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // Add HATEOAS links
        Link selfLink = linkTo(BookController.class).slash(id).withSelfRel();
        book.add(selfLink);

        return book;
    }
}
