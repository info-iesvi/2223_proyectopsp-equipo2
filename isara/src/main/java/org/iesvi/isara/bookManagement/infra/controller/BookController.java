package org.iesvi.isara.bookManagement.infra.controller;

import org.iesvi.isara.bookManagement.domain.Book;
import org.iesvi.isara.bookManagement.infra.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the Book Entity.
 * This serves as an intermediary between the BookServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface BookController {

    /**
     * GET method to obtain a list with all the books registered in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/books")
    ResponseEntity<?> getAllBooks();

    /**
     * GET method to obtain the data of a book registered in the repository by id.
     *
     * @param id Author identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/book/{id}")
    ResponseEntity<?> getBookById(@PathVariable Long id);

    /**
     * POST method to add a new book to the repository.
     *
     * @param book Data of the new author.
     * @return HTTP code 201 OK if created successfully.
     */
    @PostMapping("/book")
    ResponseEntity<BookDTO> addNewBook(@Validated @RequestBody Book book);

    /**
     * PUT method to modify the data of an existing book in the repository.
     * This will be searched by id.
     *
     * @param editBook New book data.
     * @param id Book identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/book/{id}")
    ResponseEntity<?> editBook(@RequestBody Book editBook, @PathVariable Long id);

    /**
     * DELETE method to remove a book from the repository by id.
     *
     * @param id Book identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/book/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id);
}
