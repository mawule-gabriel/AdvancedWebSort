package org.example.advancedwebsort.model;

import org.springframework.hateoas.RepresentationModel;

public class Book extends RepresentationModel<Book> {
    private Long id;
    private String title;
    private String author;

    // Constructors, Getters, and Setters
    public Book() {}

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

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
