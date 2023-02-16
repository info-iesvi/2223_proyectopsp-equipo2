package org.iesvi.isara.controller;

import org.iesvi.isara.model.UserCustomer;
import org.iesvi.isara.model.dto.UserCustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer of the UserCustomer Entity.
 * This serves as an intermediary between the UserCustomerServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
public interface UserCustomerController {

    /**
     * GET method to obtain a list with all the user customer in the repository.
     *
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/user/customer")
    ResponseEntity<?> getAllUserCustomers();

    /**
     * GET method to obtain the data of a user customer registered in the repository by id.
     *
     * @param id User customer identifier.
     * @return HTTP code 200 OK if successful.
     */
    @GetMapping("/user/customer/{id}")
    ResponseEntity<?> getUserCustomerById(Long id);

    /**
     * POST method to add a new user customer to the repository.
     *
     * @param newUserCustomer Data of the new user customer.
     * @return HTTP code 201 Created if successful.
     */
    @PostMapping("/user/customer")
    ResponseEntity<UserCustomerDTO> addNewUserCustomer(@RequestBody UserCustomer newUserCustomer);

    /**
     * PUT method to modify the data of an existing user customer in the repository.
     *
     * @param editUserCustomer New user customer data.
     * @param id User customer identifier.
     * @return HTTP code 200 OK if the changes have been saved successfully.
     */
    @PutMapping("/user/customer/{id}")
    ResponseEntity<?> editUserCustomer(@RequestBody UserCustomer editUserCustomer, @PathVariable Long id);

    /**
     * DELETE method to remove a user customer from the repository by id.
     *
     * @param id User customer identifier.
     * @return HTTP code 202 No content if it was removed successfully.
     */
    @DeleteMapping("/user/customer/{id}")
    ResponseEntity<?> deleteUserCustomerById(@PathVariable Long id);
}
