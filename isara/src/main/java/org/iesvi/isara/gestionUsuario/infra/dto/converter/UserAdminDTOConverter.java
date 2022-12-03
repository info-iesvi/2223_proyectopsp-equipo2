package org.iesvi.isara.gestionUsuario.infra.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.gestionUsuario.domain.UserAdmin;
import org.iesvi.isara.gestionUsuario.infra.dto.UserAdminDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdminDTOConverter {
    private final ModelMapper modelMapper;

    public UserAdminDTO convertToDto(UserAdmin userAdmin) {
        return modelMapper.map(userAdmin, UserAdminDTO.class);
    }
}
