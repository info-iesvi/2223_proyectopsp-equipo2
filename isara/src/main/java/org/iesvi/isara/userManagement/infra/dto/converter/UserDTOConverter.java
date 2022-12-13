package org.iesvi.isara.userManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.userManagement.domain.User;
import org.iesvi.isara.userManagement.infra.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Isa González & Sara Palma
 */
@Component
@RequiredArgsConstructor
public class UserDTOConverter {
    private final ModelMapper modelMapper;

    public UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
