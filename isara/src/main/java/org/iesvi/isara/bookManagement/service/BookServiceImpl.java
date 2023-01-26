package org.iesvi.isara.bookManagement.service;

import org.iesvi.isara.bookManagement.domain.Book;
import org.iesvi.isara.bookManagement.infra.dto.BookDTO;
import org.iesvi.isara.bookManagement.infra.dto.converter.BookDTOConverter;
import org.iesvi.isara.bookManagement.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    /**
     * Method to list the books of the repository.
     *
     * @return A list of books.
     */
    @Override
    public List<BookDTO> getAllBooks() {
        return BookDTOConverter.convertListToDto(bookRepository.findAll());
    }

    /**
     * Method to display the data of a book by id.
     *
     * @param id Identification of book.
     * @return The data of the book.
     */
    @Override
    public BookDTO getBookById(Long id) {
        return BookDTOConverter.convertToDto(bookRepository.findById(id));
    }

    /**
     * Method to save the data of the book in the repository.
     * This method will be used both to create a new book and to edit an exiting one.
     *
     * @param book The book's data.
     * @return The data of the book saved.
     */
    @Override
    public BookDTO saveBook(Book book) {
        return BookDTOConverter.convertToDto(bookRepository.save(book));
    }

    /**
     * Method to delete a book by id.
     *
     * @param id Identification of book to delete.
     */
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
