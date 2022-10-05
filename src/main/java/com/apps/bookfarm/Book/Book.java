package com.apps.bookfarm.Book;

import com.apps.bookfarm.Author.Author;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table (name= "BOOK")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private Long bookID;
    @Column(name = "BOOK_TITLE")
    private String title;
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    @Column(name = "BOOK_PUBLISHER")
    private String publisher;
    @Column (name = "BOOK_ISBN")
    private int isbn;
    @Column (name = "BOOK_SUBJECT")
    private String subjects;

    public Book(String title, Author author, String publisher, int isbn, String subjects) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.subjects = subjects;
    }

    public Book() {

    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher='" + publisher + '\'' +
                ", isbn=" + isbn +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
