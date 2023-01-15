package org.iesvi.isara.authorManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class to convert Author to AuthorDTO.
 *
 * @author Isa & Sara
 */
@Component
@RequiredArgsConstructor
public class AuthorDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static AuthorDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public static List<AuthorDTO> convertListToDto(List<Author> authorsBd) {
        List<AuthorDTO> authors = new ArrayList<>();
        for (Author a : authorsBd) {
            authors.add(modelMapper.map(a, AuthorDTO.class));
        }
        return authors;
    }

    public static AuthorDTO convertToDto(Optional<Author> byId) {
        return modelMapper.map(byId, AuthorDTO.class);
    }
}
