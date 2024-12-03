package org.example.advancedwebsort.model;

import org.springframework.hateoas.RepresentationModel;

/**
 * Represents a book with an ID, title, and author.
 * Extends {@link RepresentationModel} to support HATEOAS links.
 */
public class Book extends RepresentationModel<Book> {
    private Long id;
    private String title;
    private String author;

    /**
     * Default constructor.
     */
    public Book() {}

    /**
     * Constructor to initialize a book with an ID, title, and author.
     *
     * @param id the ID of the book.
     * @param title the title of the book.
     * @param author the author of the book.
     */
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * Gets the ID of the book.
     *
     * @return the book's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     *
     * @param id the book's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
