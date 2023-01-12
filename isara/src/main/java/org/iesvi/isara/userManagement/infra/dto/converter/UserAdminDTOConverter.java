package org.iesvi.isara.userManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.iesvi.isara.userManagement.infra.dto.UserAdminDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This DTO class converts a UserAdmin object to a UserAdminDTO using the ModelMapper class.
 *
 * @author Isa González & Sara Palma
 */
@Component
@RequiredArgsConstructor
public class UserAdminDTOConverter {
    @Autowired
    private static ModelMapper modelMapper;

    public static UserAdminDTO convertToDto(UserAdmin userAdmin) {
        return modelMapper.map(userAdmin, UserAdminDTO.class);
    }
}
