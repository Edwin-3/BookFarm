package com.apps.bookfarm.Book;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final BookServiceImpl bookService;

    public BookController(BookRepository bookRepository, BookServiceImpl bookService) {

        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    //Get all books
    @GetMapping("/books")
    Iterable<Book> books()  {
        return bookService.getBooks();}

    //Get book by id
    @GetMapping("/books/{id}")
    Book oneBook(@PathVariable Long id) { return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));}

    //Create a book
    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {return bookService.addNewBook(newBook);}

    //Delete a book
    @DeleteMapping("/books/{id}")
    void deleteAuthor(@PathVariable Long id) {
        bookService.removeBook(id);
    }

    //replace a book
    @PutMapping("books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        return bookService.updateBook(newBook,id);
    }
}
