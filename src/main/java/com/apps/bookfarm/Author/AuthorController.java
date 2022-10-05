package com.apps.bookfarm.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;
    private  final AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorServiceImpl authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    //Main Route
    @GetMapping("/authors")
    Iterable<Author> allAuthors (){

        return authorService.getAuthors();
    }

    //Get By ID
    @GetMapping("/authors/{id}")
    Author oneAuthor (@PathVariable Long id){
        return authorRepository.findById(id).orElseThrow(()-> new AuthorNotFoundException(id));
    }

    @GetMapping("authors/contacts/{phone}")
    Optional<Author> authorPhone (@PathVariable int phone){ return authorRepository.findByPhoneNumber(phone);}

    //Create an Author
    @PostMapping("/authors")
    public void newAuthor(@RequestBody Author newAuthor) {
         authorService.addNewAuthor(newAuthor);
    }

    //Delete an Author
    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id){
        authorRepository.deleteById(id);
    }

    @PutMapping("authors/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {
        return authorRepository.findById(id).map(author -> {
            author.setAuthorName(newAuthor.getAuthorName());
            author.setPhoneNumber(newAuthor.getPhoneNumber());
            return authorRepository.save(newAuthor);
        }).orElseGet(()->{newAuthor.setAuthorID(id);
        return authorRepository.save(newAuthor);
        });
    }

}
