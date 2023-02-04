package org.iesvi.isara.repository;

import org.iesvi.isara.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
