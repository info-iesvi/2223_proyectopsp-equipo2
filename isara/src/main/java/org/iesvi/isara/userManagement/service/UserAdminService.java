package org.iesvi.isara.userManagement.service;

import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.iesvi.isara.userManagement.infra.dto.UserAdminDTO;
import org.iesvi.isara.userManagement.infra.dto.converter.UserAdminDTOConverter;
import org.iesvi.isara.userManagement.infra.persistence.UserAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserAdminService {
    @Autowired
    private UserAdminRepository userAdminRepository;

    public List<UserAdminDTO> getAllUserAdmin() {
        List<UserAdmin> adminList = userAdminRepository.findAll();
        List<UserAdminDTO> adminDTOList = new ArrayList<>();
        for (UserAdmin userAdmin : adminList) {
            UserAdminDTO adminDTO = UserAdminDTOConverter.convertToDto(userAdmin);
            adminDTOList.add(adminDTO);
        }
        return adminDTOList;
    }
}
