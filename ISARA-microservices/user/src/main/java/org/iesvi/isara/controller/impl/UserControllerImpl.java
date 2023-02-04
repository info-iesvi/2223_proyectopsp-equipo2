package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.UserController;
import org.iesvi.isara.model.User;
import org.iesvi.isara.model.dto.UserDTO;
import org.iesvi.isara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller layer of the User Entity.
 * This serves as an intermediary between the UserServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<UserDTO> addNewUser(User newUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
    }

    @Override
    public ResponseEntity<?> editUser(User editUser, Long id) {
        editUser.setIdUser(id);
        return ResponseEntity.ok(userService.saveUser(editUser));
    }

    @Override
    public ResponseEntity<?> deleteUserById(Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
