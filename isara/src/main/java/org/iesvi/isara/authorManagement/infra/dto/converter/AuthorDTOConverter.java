package org.iesvi.isara.authorManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.authorManagement.domain.Author;
import org.iesvi.isara.authorManagement.infra.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorDTOConverter {
    private final ModelMapper modelMapper;

    public static AuthorDTO convertToDto(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }
}
