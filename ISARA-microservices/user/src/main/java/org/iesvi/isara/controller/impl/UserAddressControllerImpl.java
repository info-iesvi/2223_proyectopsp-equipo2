package org.iesvi.isara.controller.impl;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.controller.UserAddressController;
import org.iesvi.isara.model.UserAddress;
import org.iesvi.isara.model.dto.UserAddressDTO;
import org.iesvi.isara.service.impl.UserAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller layer of the UserAddress Entity.
 * This serves as an intermediary between the UserAddressServiceImpl class and the end user making the HTTP requests.
 *
 * @author Isa & Sara
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserAddressControllerImpl implements UserAddressController {

    @Autowired
    private UserAddressServiceImpl userAddressService;

    @Override
    public ResponseEntity<?> getAllUserAddress() {
        return ResponseEntity.ok(userAddressService.getAllUserAddress());
    }

    @Override
    public ResponseEntity<?> getUserAddressById(Long id) {
        return ResponseEntity.ok(userAddressService.getUserAddressById(id));
    }

    @Override
    public ResponseEntity<UserAddressDTO> addNewUserAddress(@Validated @RequestBody UserAddress newUserAddress) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userAddressService.saveUserAddress(newUserAddress));
    }

    @Override
    public ResponseEntity<?> editUserAddress(@RequestBody UserAddress editUserAddress, @PathVariable Long id) {
        editUserAddress.setIdAddress(id);
        return ResponseEntity.ok(userAddressService.saveUserAddress(editUserAddress));
    }

    @Override
    public ResponseEntity<?> deleteUserAddress(Long id) {
        userAddressService.deleteUserAddress(id);
        return ResponseEntity.noContent().build();
    }
}
