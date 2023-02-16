package org.iesvi.isara.repository;

import org.iesvi.isara.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
