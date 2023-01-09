package org.iesvi.isara.userManagement.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.iesvi.isara.userManagement.infra.dto.CreateUserAdminDTO;
import org.iesvi.isara.userManagement.infra.dto.UpdateUserAdminDTO;
import org.iesvi.isara.userManagement.infra.dto.UserAdminDTO;
import org.iesvi.isara.userManagement.infra.dto.converter.UserAdminDTOConverter;
import org.iesvi.isara.userManagement.infra.persistence.UserAdminRepository;
import org.iesvi.isara.shared.domain.UserAddress;
import org.iesvi.isara.shared.infra.persistence.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserAdmin controller where CRUD methods are declared.
 *
 * @author Isa González & Sara Palma
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserAdminController {
    @Autowired
    private final UserAdminRepository userAdminRepository;

    @Autowired
    private final UserAdminDTOConverter userAdminDTOConverter;

    @Autowired
    private final AddressRepository addressRepository;

    /**
     * Method to obtain a list with all users.
     *
     * @return 404 Not Found if it does not find any user, 200 OK if it finds users and the list of them.
     */
    @GetMapping("/users/admin")
    public ResponseEntity<?> getAllUsersAdmin() {
        // The method findAll() looks for all the user admin into the repository.
        List<UserAdmin> userAdminList = userAdminRepository.findAll();

        //If the userAdminList is Empty, it will return the message 404 "Not Found"
        if (userAdminList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        //If the userAdminList is not Empty, it will return the message 200 "Ok"
        else {
            List<UserAdminDTO> userAdminDTOList = userAdminList.stream()
                    .map(userAdminDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(userAdminDTOList);
        }
    }

    /**
     * Method to get a user by his ID.
     *
     * @param id User identifier.
     * @return 404 Not Found if it does not find the user, 200 OK if it finds the user and its data.
     */
    @GetMapping("/user/admin/{id}")
    public ResponseEntity<?> getUserAdminById(@PathVariable Long id) {
        // The method findById() looks for a user admin into the repository by the user admin identification.
        UserAdmin userAdmin = userAdminRepository.findById(id).orElse(null);

        // If the User called user is null, we will receive a 404 http response code; if not, we will get the 200 http code
        if (userAdmin == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(userAdmin);
        }
    }

    /**
     * Method to add a new admin user.
     *
     * @param newUserAdmin Data of the new user.
     * @return 201 Created if the new user has been inserted successfully.
     */
    @PostMapping("/user/admin")
    public ResponseEntity<UserAdmin> addNewUserAdmin(@RequestBody CreateUserAdminDTO newUserAdmin) {
        // We create a UserAdmin called userAdmin
        UserAdmin userAdmin = new UserAdmin();

        // We put the new information
        userAdmin.setUserName(newUserAdmin.getUserName());
        userAdmin.setPassword(newUserAdmin.getPassWord());
        userAdmin.setFirstName(newUserAdmin.getFirstName());
        userAdmin.setLastName(newUserAdmin.getLastName());
        userAdmin.setEmail(newUserAdmin.getEmail());
        userAdmin.setSalary(newUserAdmin.getSalary());

        // If the user admin is created correctly, it will return the 201 Http response code
        return ResponseEntity.status(HttpStatus.CREATED).body(userAdminRepository.save(userAdmin));
    }

    /**
     * Method to edit an admin user.
     *
     * @param editUserAdmin New user data.
     * @param id User identifier.
     * @return 200 OK if edited successfully, 404 Not Found if not.
     */
    @PutMapping("/user/admin/{id}")
    public ResponseEntity<?> editUserAdmin(@RequestBody UpdateUserAdminDTO editUserAdmin, @PathVariable Long id) {
        // This looks for the user by id to edit the attributes
        return userAdminRepository.findById(id).map(userAdmin -> {
            UserAddress address = addressRepository.findById(editUserAdmin.getAddress().getIdAddress()).orElse(null);

            // We put the new information
            userAdmin.setUserName(editUserAdmin.getUserName());
            userAdmin.setPassword(editUserAdmin.getPassword());
            userAdmin.setFirstName(editUserAdmin.getFirstName());
            userAdmin.setLastName(editUserAdmin.getLastName());
            userAdmin.setAddress(address);
            userAdmin.setPhoneNumber(editUserAdmin.getPhoneNumber());
            userAdmin.setEmail(editUserAdmin.getEmail());
            userAdmin.setSalary(editUserAdmin.getSalary());

            // If the user edits correctly, it will return the 200 Http response code
            return ResponseEntity.ok(userAdminRepository.save(userAdmin));

            // If the user edits incorrectly, it will return the 404 Http response code
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method to delete a user by his ID
     *
     * @param id User identifier.
     * @return 202 No Content if the user was successfully deleted, 404 Not Found if the user was not found.
     */
    @DeleteMapping("/user/admin/{id}")
    public ResponseEntity<?> deleteUserAdmin(@PathVariable Long id) {
        // If the id exists, we will delete the user and get the 202 http response code
        if (userAdminRepository.existsById(id)) {
            userAdminRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // If it doesn't exist, we will get the 404 http response code (Not found)
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
