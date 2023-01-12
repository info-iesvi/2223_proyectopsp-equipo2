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
import org.iesvi.isara.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User controller where CRUD methods are declared.
 *
 * @author Isa González & Sara Palma
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
        // The method findAll() looks for all the users into the repository.
        List<User> usersList = userRepository.findAll();

        // if userList is Empty, it will return the 404 Http response code.
        if (usersList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // if the userList is not Empty, it will execute the following code (it'll save the information
        // in the List<UserDTO> and it'll return the ResponseEntity message [200])
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
        // The method findById() looks for a user into the repository by the user identification.
        User user = userRepository.findById(id).orElse(null);

        // if the User called user is null, we will receive a 404 http response code; if not, we will get the 200 http code
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
        // This adds the newUser name to the user
        user.setUserName(newUser.getUserName());
        // This adds the newUser password to the user
        user.setPassword(newUser.getPassword());
        // This adds the newUser email to the user
        user.setEmail(newUser.getEmail());

        // If the user is created correctly, it will return the 201 Http response code
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
        // This looks for the user by id to edit the attributes
        return userRepository.findById(id).map(user -> {
            UserAddress address;
            // If we sent all address data into request, it's a new address
            if (editUser.getAddress().getKindOfStreet() != null) {
                address = new UserAddress(
                        editUser.getAddress().getIdAddress(),
                        editUser.getAddress().getKindOfStreet(),
                        editUser.getAddress().getStreetName(),
                        editUser.getAddress().getPostalCode(),
                        editUser.getAddress().getCity()
                );
            }
            // If we don't send all address data into request, we will look for it
            else {
                address = addressRepository.findById(editUser.getAddress().getIdAddress()).orElse(null);
            }

            user.setUserName(editUser.getUserName());
            user.setPassword(editUser.getPassword());
            user.setFirstName(editUser.getFirstName());
            user.setLastName(editUser.getLastName());
            user.setAddress(address);
            user.setPhoneNumber(editUser.getPhoneNumber());
            user.setEmail(editUser.getEmail());

            // If it is a new address, save it before the user
            if (editUser.getAddress().getKindOfStreet() != null) {
                addressRepository.save(address);
            }

            // If the user edits correctly, it will return the 200 Http response code
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
        // If the id exists, we will delete the user and get the 202 http response code
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // If it doesn't exist, we will get the 404 http response code (Not found)
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private UserService userService;

    /**
     *
     * @param user
     * @return userService.saveUser(user)
     */
    @PostMapping("/user")
    public User signIn(@Validated @RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     *
     * @return userService.getAllUsers()
     */
    @GetMapping("/users")
    public List<User> viewUserList() {
        return userService.getAllUsers();
    }

    /**
     *
     * @param id
     * @param user
     * @return userService.saveUser(user)
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @Validated @RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Method to delete a user by his ID
     * @param id User identification
     */
    @DeleteMapping("/user/{id}")
    public void deleteOneUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
