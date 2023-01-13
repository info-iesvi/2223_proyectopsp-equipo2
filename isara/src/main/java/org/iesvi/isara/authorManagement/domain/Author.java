package org.iesvi.isara.authorManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idAuthor;
    private String firstNameAuthor;
    private String lastNameAuthor;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String nationality;
}
