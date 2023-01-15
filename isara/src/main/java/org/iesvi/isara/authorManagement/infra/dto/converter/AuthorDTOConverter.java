package org.iesvi.isara.authorManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthorDTOConverter {
    private static final ModelMapper modelMapper = null;

    public static AuthorDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public static List<Author> convertListToDto(List<Author> all) {
        return (List<Author>) modelMapper.map(all, AuthorDTO.class);
    }
}
