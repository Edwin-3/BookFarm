package com.apps.bookfarm.Book;

public class BookNotFoundException extends RuntimeException{

    BookNotFoundException(Long id) {
        super("Error: Could not find Book with id: " + id);
    }
}
