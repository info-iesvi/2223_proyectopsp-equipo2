package org.iesvi.isara.authorManagement.infra.controller;

import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the Author Entity.
 * This serves as an intermediary between the AuthorServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface AuthorController {

    /**
     * GET method to obtain a list with all the authors registered in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/authors")
    ResponseEntity<?> getAllAuthors();

    /**
     * GET method to obtain the data of an author registered in the repository by id.
     *
     * @param id Author identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/author/{id}")
    ResponseEntity<?> getAuthorById(@PathVariable Long id);

    /**
     * POST method to add a new author to the repository.
     *
     * @param author Data of the new author.
     * @return HTTP code 201 OK if created successfully.
     */
    @PostMapping("/author")
    ResponseEntity<AuthorDTO> addNewAuthor(@Validated @RequestBody Author author);

    /**
     * PUT method to modify the data of an existing author in the repository.
     * This will be searched by id.
     *
     * @param editAuthor New author data.
     * @param id Author identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/author/{id}")
    ResponseEntity<?> editAuthor(@RequestBody Author editAuthor, @PathVariable Long id);

    /**
     * DELETE method to remove an author from the repository by id.
     *
     * @param id Author identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/author/{id}")
    ResponseEntity<?> deleteAuthor(@PathVariable Long id);
}
