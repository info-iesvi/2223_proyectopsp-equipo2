package org.iesvi.isara.controller;

import org.iesvi.isara.model.UserAdmin;
import org.iesvi.isara.model.dto.UserAdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the UserAdmin Entity.
 * This serves as an intermediary between the UserAdminServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface UserAdminController {

    /**
     * GET method to obtain a list with all the user admins in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/user/admin")
    ResponseEntity<?> getAllUserAdmins();

    /**
     * GET method to obtain the data of a user admin registered in the repository by id.
     *
     * @param id User admin identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/user/admin/{id}")
    ResponseEntity<?> getUserAdminById(Long id);

    /**
     * POST method to add a new user admin to the repository.
     *
     * @param newUserAdmin Data of the new user admin.
     * @return HTTP code 201 Created if successful.
     */
    @PostMapping("/user/admin")
    ResponseEntity<UserAdminDTO> addNewUserAdmin(@RequestBody UserAdmin newUserAdmin);

    /**
     * PUT method to modify the data of an existing user admin in the repository.
     *
     * @param editUserAdmin New user admin data.
     * @param id User admin identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/user/admin/{id}")
    ResponseEntity<?> editUserAdmin(@RequestBody UserAdmin editUserAdmin, @PathVariable Long id);

    /**
     * DELETE method to remove a user admin from the repository by id.
     *
     * @param id User admin identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/user/admin/{id}")
    ResponseEntity<?> deleteUserAdminById(@PathVariable Long id);
}
