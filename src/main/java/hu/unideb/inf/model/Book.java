package hu.unideb.inf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @Column
    private Long id;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private String publisher;

    @Column
    private Long yearOfPublication;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Long yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Book(Long id, String author, String title, String publisher, Long yearOfPublication) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
    }
}
