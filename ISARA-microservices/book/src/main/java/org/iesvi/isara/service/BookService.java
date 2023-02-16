package org.iesvi.isara.service;

import org.iesvi.isara.model.Book;
import org.iesvi.isara.model.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the Book Entity.
 * This serves as an intermediary between the Book class and the BookController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface BookService {

    /**
     * Method to list the books of the repository.
     *
     * @return A list of books.
     */
    List<BookDTO> getAllBooks();

    /**
     * Method to display the data of a book by id.
     *
     * @param id Identification of book.
     * @return The data of the book.
     */
    BookDTO getBookById(Long id);

    /**
     * Method to save the data of the book in the repository.
     * This method will be used both to create a new book and to edit an exiting one.
     *
     * @param book The book's data.
     * @return The data of the book saved.
     */
    BookDTO saveBook(Book book);

    /**
     * Method to delete a book by id.
     *
     * @param id Identification of book to delete.
     */
    void deleteBook(Long id);
}
