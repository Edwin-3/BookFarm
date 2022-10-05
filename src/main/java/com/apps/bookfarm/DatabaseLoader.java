package com.apps.bookfarm;

import com.apps.bookfarm.Author.Author;
import com.apps.bookfarm.Author.AuthorRepository;
import com.apps.bookfarm.Book.Book;
import com.apps.bookfarm.Book.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    public static  final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Bean
    CommandLineRunner initDatabase (AuthorRepository authorRepository, BookRepository bookRepository){
        return  args -> {

            //save new author
            authorRepository.save(new Author("Mike Wallace",2333444));
            authorRepository.save(new Author("Hellen Simons",9999999));
            authorRepository.save(new Author("Lisa Wright",44447777));

            //Save new Book

            bookRepository.save(new Book("Rise of AI",authorRepository.findAuthorByAuthorID(2L),"Los Angeles", 2344, "Technology"));
            bookRepository.save(new Book("Counter-hypnosis",authorRepository.findAuthorByAuthorID(3L),"Longhorn", 995, "Math"));
            bookRepository.save(new Book("Weeeh!!!",authorRepository.findAuthorByAuthorID(1L),"Singapore", 1111, "Life"));

            //Log the author entry
            authorRepository.findAll().forEach(author -> log.info("Preloaded Author: " + author));
            bookRepository.findAll().forEach(book -> log.info("Preloaded Author: " + book));

        };
    }

}
