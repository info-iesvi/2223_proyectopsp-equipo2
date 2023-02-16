package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.UserCustomerController;
import org.iesvi.isara.model.UserCustomer;
import org.iesvi.isara.model.dto.UserCustomerDTO;
import org.iesvi.isara.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller layer of the UserCustomer Entity.
 * This serves as an intermediary between the UserCustomerServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserCustomerControllerImpl implements UserCustomerController {

    @Autowired
    private UserCustomerService userCustomerService;

    @Override
    public ResponseEntity<?> getAllUserCustomers() {
        return ResponseEntity.ok(userCustomerService.getAllUserCustomers());
    }

    @Override
    public ResponseEntity<?> getUserCustomerById(Long id) {
        return ResponseEntity.ok(userCustomerService.getUserCustomerById(id));
    }

    @Override
    public ResponseEntity<UserCustomerDTO> addNewUserCustomer(UserCustomer newUserCustomer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userCustomerService.saveUserCustomer(newUserCustomer));
    }

    @Override
    public ResponseEntity<?> editUserCustomer(UserCustomer editUserCustomer, Long id) {
        editUserCustomer.setIdUser(id);
        return ResponseEntity.ok(userCustomerService.saveUserCustomer(editUserCustomer));
    }

    @Override
    public ResponseEntity<?> deleteUserCustomerById(Long id) {
        userCustomerService.deleteUserCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
