package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.UserAdminController;
import org.iesvi.isara.model.UserAdmin;
import org.iesvi.isara.model.dto.UserAdminDTO;
import org.iesvi.isara.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller layer of the UserAdmin Entity.
 * This serves as an intermediary between the UserAdminServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserAdminControllerImpl implements UserAdminController {

    @Autowired
    private UserAdminService userAdminService;

    @Override
    public ResponseEntity<?> getAllUserAdmins() {
        return ResponseEntity.ok(userAdminService.getAllUserAdmins());
    }

    @Override
    public ResponseEntity<?> getUserAdminById(Long id) {
        return ResponseEntity.ok(userAdminService.getUserAdminById(id));
    }

    @Override
    public ResponseEntity<UserAdminDTO> addNewUserAdmin(UserAdmin newUserAdmin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userAdminService.saveUserAdmin(newUserAdmin));
    }

    @Override
    public ResponseEntity<?> editUserAdmin(UserAdmin editUserAdmin, Long id) {
        editUserAdmin.setIdUser(id);
        return ResponseEntity.ok(userAdminService.saveUserAdmin(editUserAdmin));
    }

    @Override
    public ResponseEntity<?> deleteUserAdminById(Long id) {
        userAdminService.deleteUserAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
