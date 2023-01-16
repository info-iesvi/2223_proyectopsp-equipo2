package org.iesvi.isara.bookManagement.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.bookManagement.domain.Book;
import org.iesvi.isara.bookManagement.infra.dto.BookDTO;
import org.iesvi.isara.bookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/isara")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/book")
    public ResponseEntity<BookDTO> addNewBook(@Validated @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> editBook(@RequestBody Book editBook, @PathVariable Long id) {
        editBook.setIdBook(id);
        return ResponseEntity.ok(bookService.saveBook(editBook));
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
