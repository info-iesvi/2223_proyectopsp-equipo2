package org.iesvi.isara.controller;

import org.iesvi.isara.model.User;
import org.iesvi.isara.model.UserEmail;
import org.iesvi.isara.model.dto.UserAccessDTO;
import org.iesvi.isara.model.dto.UserDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the User Entity.
 * This serves as an intermediary between the UserServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface UserController {

    /**
     * GET method to obtain a list with all the users in the repository.
     *
     * @param authHeader Data of the user running this operation
     * @return HTTP code 200 OK if successful - HTTP code 404 Not Found if it's not.
     */
    @GetMapping("/user")
    ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String authHeader);

    /**
     * GET method to obtain the data of a user registered in the repository by id.
     *
     * @param id User identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/user/{id}")
    ResponseEntity<?> getUserById(@PathVariable Long id);

    /**
     * POST method to add a new user to the repository.
     *
     * @param authHeader Data of the user running this operation
     * @param newUser Data of the new user.
     * @return HTTP code 201 Created if successful.
     */
    @PostMapping("/user")
    ResponseEntity<?> addNewUser(@RequestHeader("Authorization") String authHeader, @RequestBody User newUser);

    /**
     * PUT method to modify the data of an existing user in the repository.
     *
     * @param editUser New user data.
     * @param id User identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/user/{id}")
    ResponseEntity<?> editUser(@RequestBody User editUser, @PathVariable Long id);

    /**
     * DELETE method to remove a user from the repository by id.
     *
     * @param id User identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUserById(@PathVariable Long id);

    /**
     * POST method to email to the server Gmail account.
     *
     * @param email Email header & message body.
     * @return HTTP code 200 OK if it was sent successfully.
     */
    @PostMapping("/email")
    ResponseEntity<?> sendEmail(@RequestBody UserEmail email);

//    @GetMapping("/login")
//    ResponseEntity<?> login(@RequestBody UserAccessDTO userAccessDTO);
}
