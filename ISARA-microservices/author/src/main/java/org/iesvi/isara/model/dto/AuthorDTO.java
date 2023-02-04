package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorDTO {
    private Long idAuthor;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String nationality;
}
