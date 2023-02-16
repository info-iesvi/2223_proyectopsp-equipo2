package org.iesvi.isara.controller;

import org.iesvi.isara.model.UserAddress;
import org.iesvi.isara.model.dto.UserAddressDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the UserAddress Entity.
 * This serves as an intermediary between the UserAddressServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface UserAddressController {

    /**
     * GET method to obtain a list with all the user address registered in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/address")
    ResponseEntity<?> getAllUserAddress();

    /**
     * GET method to obtain the data of a user address registered in the repository by id.
     *
     * @param id User address identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/address/{id}")
    ResponseEntity<?> getUserAddressById(@PathVariable Long id);

    /**
     * POST method to add a new user address to the repository.
     *
     * @param newUserAddress Data of the new user address.
     * @return HTTP code 201 Created if successful.
     */
    @PostMapping("/address")
    ResponseEntity<UserAddressDTO> addNewUserAddress(@RequestBody UserAddress newUserAddress);

    /**
     * PUT method to modify the data of an existing user address in the repository.
     *
     * @param editUserAddress New user address data.
     * @param id User address identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/address/{id}")
    ResponseEntity<?> editUserAddress(@RequestBody UserAddress editUserAddress, @PathVariable Long id);

    /**
     * DELETE method to remove a user address from the repository by id.
     *
     * @param id User address identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/address/{id}")
    ResponseEntity<?> deleteUserAddress(@PathVariable Long id);
}
