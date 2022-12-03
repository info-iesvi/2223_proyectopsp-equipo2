package org.iesvi.isara.gestionUsuario.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.gestionUsuario.domain.User;
import org.iesvi.isara.gestionUsuario.infra.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDTOConverter {
    private final ModelMapper modelMapper;

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
