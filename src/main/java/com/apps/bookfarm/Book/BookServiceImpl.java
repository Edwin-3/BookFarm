package com.apps.bookfarm.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {this.bookRepository = bookRepository;}

    @Override
    public Book addNewBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(book.getIsbn());
        if(optionalBook.isPresent()){
            throw new IllegalStateException("Book already exists");
        }
        bookRepository.save(book);

        return book;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void removeBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book updateBook(Book book, Long id) {
        bookRepository.findById(id).map(Book -> {
            book.setBookID(book.getBookID());
            book.setTitle(book.getTitle());
            book.setAuthor(book.getAuthor());
            book.setPublisher(book.getPublisher());
            book.setIsbn(book.getIsbn());
            book.setSubjects(book.getSubjects());
            return bookRepository.save(book);
        }).orElseGet(()->{book.setBookID(id);
            return bookRepository.save(book);
        });

        return book;
    }
}
