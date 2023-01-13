package org.iesvi.isara.authorManagement.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/isara/book")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/author")
    public Author createNewAuthor(@Validated @RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping("/authors")
    public List<Author> viewAuthorList() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public Optional<Author> viewAuthor(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@PathVariable String id, @Validated @RequestBody Author author) {
        return authorService.editAuthor(author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
