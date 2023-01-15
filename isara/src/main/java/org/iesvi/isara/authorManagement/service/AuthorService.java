package org.iesvi.isara.authorManagement.service;

import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.iesvi.isara.authorManagement.infra.dto.converter.AuthorDTOConverter;
import org.iesvi.isara.authorManagement.persistence.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer of the Author Entity.
 * This serves as an intermediary between the Author class and the AuthorController controller.
 */

/**
 * @author Isa & Sara
 */
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Method to list the authors of the repository.
     *
     * @return A list of authors.
     */
    public List<AuthorDTO> getAllAuthors() {
        return AuthorDTOConverter.convertListToDto(authorRepository.findAll());
    }

    /**
     * Method to display the data of an author by id.
     *
     * @param id Identification of author.
     * @return The data of the author.
     */
    public AuthorDTO getAuthorById(Long id) {
        return AuthorDTOConverter.convertToDto(authorRepository.findById(id));
    }

    /**
     * Method to save the data of the author in the repository.
     * This method will be used both to create a new author and to edit an existing one.
     *
     * @param author The author's data.
     * @return The data of the author.
     */
    public AuthorDTO saveAuthor(Author author) {
        return AuthorDTOConverter.convertToDto(authorRepository.save(author));
    }

    /**
     * Method to delete an author by id.
     *
     * @param id Identification of author to delete.
     */
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
