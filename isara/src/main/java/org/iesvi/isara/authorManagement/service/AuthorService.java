package org.iesvi.isara.authorManagement.service;

import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.persistence.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    // TODO: Review method to use AuthorDTO
    public Author saveAuthor(Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    public Author editAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}
