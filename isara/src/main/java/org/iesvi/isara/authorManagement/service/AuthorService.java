package org.iesvi.isara.authorManagement.service;

import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.iesvi.isara.authorManagement.infra.dto.converter.AuthorDTOConverter;
import org.iesvi.isara.authorManagement.persistence.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDTO> getAllAuthors() {
        return AuthorDTOConverter.convertListToDto(authorRepository.findAll());
    }

    public Optional<Author> getAuthorById(Long id) {
        return (authorRepository.findById(id));
    }

    public AuthorDTO saveAuthor(Author author) {
        return AuthorDTOConverter.convertToDto(authorRepository.save(author));
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
