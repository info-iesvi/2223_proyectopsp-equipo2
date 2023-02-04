package org.iesvi.isara.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idBook;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id_author")
    private Author author;
    private Double prize;
    private Boolean available;
}

