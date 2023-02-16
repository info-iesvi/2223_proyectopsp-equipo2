package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.UserAdmin;
import org.iesvi.isara.model.dto.UserAdminDTO;
import org.iesvi.isara.model.dto.converter.UserAdminDTOConverter;
import org.iesvi.isara.repository.UserAdminRepository;
import org.iesvi.isara.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserAdmin Entity.
 * This serves as an intermediary between the UserAdmin class and the UserAdminController controller.
 *
 * @author Isa & Sara
 */
@Service
public class UserAdminServiceImpl implements UserAdminService {

    @Autowired
    private UserAdminRepository userAdminRepository;

    @Override
    public List<UserAdminDTO> getAllUserAdmins() {
        return UserAdminDTOConverter.convertListToDto(userAdminRepository.findAll());
    }

    @Override
    public UserAdminDTO getUserAdminById(Long id) {
        return UserAdminDTOConverter.convertToDto(userAdminRepository.findById(id));
    }

    @Override
    public UserAdminDTO saveUserAdmin(UserAdmin userAdmin) {
        return UserAdminDTOConverter.convertToDto(userAdminRepository.save(userAdmin));
    }

    @Override
    public void deleteUserAdmin(Long id) {
        userAdminRepository.deleteById(id);
    }
}
