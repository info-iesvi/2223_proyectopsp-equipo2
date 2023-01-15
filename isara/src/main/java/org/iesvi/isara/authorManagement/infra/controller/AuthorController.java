package org.iesvi.isara.authorManagement.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.iesvi.isara.authorManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/isara/book")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping("/author")
    public ResponseEntity<AuthorDTO> addNewAuthor(@Validated @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(author));
    }

    @PutMapping("/author/{id}")
    public ResponseEntity<?> editAuthor(@RequestBody Author editAuthor, @PathVariable Long id) {
        return ResponseEntity.ok(authorService.saveAuthor(editAuthor));
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
