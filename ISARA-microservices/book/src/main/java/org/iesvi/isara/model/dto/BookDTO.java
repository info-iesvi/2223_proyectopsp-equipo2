package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.model.Author;

@Getter
@Setter
public class BookDTO {
    private Long idBook;
    private String title;
    private Author author;
    private double prize;
    private boolean available;
}
