package org.iesvi.isara.service;

import org.iesvi.isara.model.Author;
import org.iesvi.isara.model.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the Author Entity.
 * This serves as an intermediary between the Author class and the AuthorController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface AuthorService {

    /**
     * Method to list the authors of the repository.
     *
     * @return A list of authors.
     */
    List<AuthorDTO> getAllAuthors();

    /**
     * Method to display the data of an author by id.
     *
     * @param id Identification of author.
     * @return The data of the author.
     */
    AuthorDTO getAuthorById(Long id);

    /**
     * Method to save the data of the author in the repository.
     * This method will be used both to create a new author and to edit an existing one.
     *
     * @param author The author's data.
     * @return The data of the author saved.
     */
    AuthorDTO saveAuthor(Author author);

    /**
     * Method to delete an author by id.
     *
     * @param id Identification of author to delete.
     */
    void deleteAuthor(Long id);
}

