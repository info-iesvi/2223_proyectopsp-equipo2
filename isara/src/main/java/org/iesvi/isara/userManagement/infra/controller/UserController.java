package org.iesvi.isara.userManagement.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.shared.domain.UserAddress;
import org.iesvi.isara.userManagement.domain.User;
import org.iesvi.isara.userManagement.infra.dto.CreateUserDTO;
import org.iesvi.isara.userManagement.infra.dto.UpdateUserDTO;
import org.iesvi.isara.userManagement.infra.dto.UserDTO;
import org.iesvi.isara.userManagement.infra.dto.converter.UserDTOConverter;
import org.iesvi.isara.userManagement.infra.persistence.UserRepository;
import org.iesvi.isara.shared.infra.persistence.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User controller where CRUD methods are declared.
 *
 * @author Isa González
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserController {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserDTOConverter userDTOConverter;

    /**
     * Method to obtain a list with all users.
     *
     * @return 404 Not Found if it does not find any user, 200 OK if it finds users and the list of them.
     */
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> usersList = userRepository.findAll();

        if (usersList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<UserDTO> userDTOList = usersList.stream()
                    .map(userDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userDTOList);
        }
    }

    /**
     * Method to get a user by his ID.
     *
     * @param id User identifier.
     * @return 404 Not Found if it does not find the user, 200 OK if it finds the user and its data.
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(user);
        }
    }

    /**
     * Method to add a new user.
     *
     * @param newUser Data of the new user.
     * @return 201 Created if the new user has been inserted successfully.
     */
    @PostMapping("/user")
    public ResponseEntity<User> addNewUser(@RequestBody CreateUserDTO newUser) {
        User user = new User();
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    /**
     * Method to edit a user.
     *
     * @param editUser New user data.
     * @param id User identifier.
     * @return 200 OK if edited successfully, 404 Not Found if not.
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUser(@RequestBody UpdateUserDTO editUser, @PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            UserAddress address = addressRepository.findById(editUser.getAddress().getIdAddress()).orElse(null);

            user.setUserName(editUser.getUserName());
            user.setPassword(editUser.getPassword());
            user.setFirstName(editUser.getFirstName());
            user.setLastName(editUser.getLastName());
            user.setAddress(address);
            user.setPhoneNumber(editUser.getPhoneNumber());
            user.setEmail(editUser.getEmail());

            return ResponseEntity.ok(userRepository.save(user));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method to delete a user by his ID
     *
     * @param id User identifier.
     * @return 202 No Content if the user was successfully deleted, 404 Not Found if the user was not found.
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
