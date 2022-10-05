package com.apps.bookfarm.Book;

import com.apps.bookfarm.Author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(int isbn);
}
