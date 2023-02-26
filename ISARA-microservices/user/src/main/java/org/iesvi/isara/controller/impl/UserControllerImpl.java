package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.UserController;
import org.iesvi.isara.model.User;
import org.iesvi.isara.model.UserEmail;
import org.iesvi.isara.model.dto.UserAccessDTO;
import org.iesvi.isara.model.dto.UserDTO;
import org.iesvi.isara.service.AuthService;
import org.iesvi.isara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.OperationsLog;

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
    @Autowired
    private AuthService authService;

    @Override
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<?> addNewUser(String authHeader, User newUser) {
        ResponseEntity<?> response;

        // The password is saved by applying a digest thanks to the method 'encodePassword'
        newUser.setPassword(authService.encodePassword(newUser.getPassword()));

        // If the credentials are valid, the new user is added
        // If not, it sends back an error message
        if (authService.validateCredentials(authHeader)) {
            response = ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
            OperationsLog.log(authService.getUser(authHeader), "User", "ADD", false);
        } else {
            String errorBody = "{" +
                    "\"message\": \"Invalid credentials\"" +
                    "}";
            response = ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorBody);
            OperationsLog.log(authService.getUser(authHeader), "User", "ADD", true);
        }
        return response;
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

    @Override
    public ResponseEntity<?> sendEmail(UserEmail email) {
        userService.sendEmail(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @Override
//    public ResponseEntity<?> login(UserAccessDTO userAccessDTO) {
//        userService.accessApp(userAccessDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
