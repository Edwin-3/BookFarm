package com.apps.bookfarm.Book;

import java.util.List;

public interface BookService {
    //Create
    public Book addNewBook(Book book);

    //Read
    public List<Book> getBooks();

    //Delete
    public void removeBook(Long id);

    //Update
    Book updateBook(Book book, Long id);
}
