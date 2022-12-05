package org.iesvi.isara.userManagement.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.iesvi.isara.userManagement.infra.dto.UserAdminDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Isa González
 */
@Component
@RequiredArgsConstructor
public class UserAdminDTOConverter {
    private final ModelMapper modelMapper;

    public UserAdminDTO convertToDto(UserAdmin userAdmin) {
        return modelMapper.map(userAdmin, UserAdminDTO.class);
    }
}
