package org.iesvi.isara.model.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.model.User;
import org.iesvi.isara.model.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This DTO class converts a User object to a UserDTO using the ModelMapper class.
 *
 * @author Isa & Sara
 */
@Component
@RequiredArgsConstructor
public class UserDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public static List<UserDTO> convertListToDto(List<User> userDB) {
        List<UserDTO> users = new ArrayList<>();
        for (User user : userDB) {
            users.add(modelMapper.map(user, UserDTO.class));
        }
        return users;
    }

    public static UserDTO convertToDto(Optional<User> userById) {
        return modelMapper.map(userById, UserDTO.class);
    }
}
