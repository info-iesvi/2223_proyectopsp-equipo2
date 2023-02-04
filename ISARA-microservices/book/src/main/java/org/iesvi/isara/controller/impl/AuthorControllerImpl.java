package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.AuthorController;
import org.iesvi.isara.model.Author;
import org.iesvi.isara.model.dto.AuthorDTO;
import org.iesvi.isara.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the Author Entity that implements the AuthorController interface.
 * This serves as an intermediary between the AuthorServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/isara/book")
public class AuthorControllerImpl implements AuthorController {
    @Autowired
    private AuthorServiceImpl authorService;

    /**
     * GET method to obtain a list with all the authors registered in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/authors")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    /**
     * GET method to obtain the data of an author registered in the repository by id.
     *
     * @param id Author identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/author/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    /**
     * POST method to add a new author to the repository.
     *
     * @param author Data of the new author.
     * @return HTTP code 201 OK if created successfully.
     */
    @PostMapping("/author")
    public ResponseEntity<AuthorDTO> addNewAuthor(@Validated @RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(author));
    }

    /**
     * PUT method to modify the data of an existing author in the repository.
     * This will be searched by id.
     *
     * @param editAuthor New author data.
     * @param id Author identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/author/{id}")
    public ResponseEntity<?> editAuthor(@RequestBody Author editAuthor, @PathVariable Long id) {
        editAuthor.setIdAuthor(id);
        return ResponseEntity.ok(authorService.saveAuthor(editAuthor));
    }

    /**
     * DELETE method to remove an author from the repository by id.
     *
     * @param id Author identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
