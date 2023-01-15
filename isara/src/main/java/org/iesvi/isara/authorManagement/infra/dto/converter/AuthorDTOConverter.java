package org.iesvi.isara.authorManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static AuthorDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public static List<AuthorDTO> convertListToDto(List<Author> all) {
        return (List<AuthorDTO>) modelMapper.map(all, AuthorDTO.class);
    }
}
