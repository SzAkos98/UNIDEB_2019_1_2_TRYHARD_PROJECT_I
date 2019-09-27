package hu.unideb.inf.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;


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
    private Date publishingDate;

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

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public Book(Long id, String author, String title, String publisher, Date publishingDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
    }
}
