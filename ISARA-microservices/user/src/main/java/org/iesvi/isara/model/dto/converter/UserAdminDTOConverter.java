package org.iesvi.isara.model.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.model.UserAdmin;
import org.iesvi.isara.model.dto.UserAdminDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This DTO class converts a UserAdmin object to a UserAdminDTO using the ModelMapper class.
 *
 * @author Isa & Sara
 */
@Component
@RequiredArgsConstructor
public class UserAdminDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserAdminDTO convertToDto(UserAdmin userAdmin) {
        return modelMapper.map(userAdmin, UserAdminDTO.class);
    }

    public static List<UserAdminDTO> convertListToDto(List<UserAdmin> userAdminsDB) {
        List<UserAdminDTO> userAdmins = new ArrayList<>();
        for (UserAdmin userAdmin : userAdminsDB) {
            userAdmins.add(modelMapper.map(userAdmin, UserAdminDTO.class));
        }
        return userAdmins;
    }

    public static UserAdminDTO convertToDto(Optional<UserAdmin> userAdminById) {
        return modelMapper.map(userAdminById, UserAdminDTO.class);
    }
}
