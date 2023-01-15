package org.iesvi.isara.bookManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idBook;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id_author")
    private Author author;
    private Double prize;
    private Boolean available;
}
