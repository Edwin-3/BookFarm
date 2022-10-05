package com.apps.bookfarm.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return  authorRepository.findAll();
    }

    @Override
    public void addNewAuthor(Author author) {
        Optional<Author> optionalAuthor = authorRepository.findByPhoneNumber(author.getPhoneNumber());
        if(optionalAuthor.isPresent()){
            throw new IllegalStateException("Author already exists");
        }
        authorRepository.save(author);
    }

    @Override
    public void removeAuthor(Long id) {
        authorRepository.deleteById(id);

    }
}
