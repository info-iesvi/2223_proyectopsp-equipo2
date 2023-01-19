package org.iesvi.isara.authorManagement.persistence;

import org.iesvi.isara.authorManagement.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
