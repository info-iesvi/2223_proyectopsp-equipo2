package org.iesvi.isara.bookManagement.persistence;

import org.iesvi.isara.bookManagement.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
