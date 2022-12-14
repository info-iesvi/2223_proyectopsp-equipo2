package org.iesvi.isara.shared.infra.controller;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.shared.domain.UserAddress;
import org.iesvi.isara.shared.infra.dto.AddressDTO;
import org.iesvi.isara.shared.infra.dto.AddressDTOConverter;
import org.iesvi.isara.shared.infra.persistence.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Isa González & Sara Palma
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/isara")
public class UserAddressController {
    private final AddressRepository addressRepository;
    private final AddressDTOConverter addressDTOConverter;

    /**
     * Method to obtain a list with all users.
     *
     * @return 404 Not Found if it does not find any user, 200 OK if it finds users and the list of them.
     */
    @GetMapping("/addresses")
    public ResponseEntity<?> getAllAddress() {
        List<UserAddress> addressList = addressRepository.findAll();

        if (addressList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<AddressDTO> addressDTOList = addressList.stream()
                    .map(addressDTOConverter::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(addressDTOList);
        }
    }

    /**
     * Method to get a user address by id.
     *
     * @param id Address identifier.
     * @return 404 Not Found if it does not find the address, 200 OK if it finds the address and its data.
     */
    @GetMapping("/address")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        UserAddress address = addressRepository.findById(id).orElse(null);

        if (address == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(address);
        }
    }

    /**
     * Method to add a new address.
     *
     * @param newAddress Data of the new address.
     * @return 201 Created if the new address has been inserted successfully.
     */
    @PostMapping("/address")
    public ResponseEntity<UserAddress> addNewAddress(@RequestBody AddressDTO newAddress) {
        UserAddress address = new UserAddress();
        address.setKindOfStreet(newAddress.getKindOfStreet());
        address.setStreetName(newAddress.getStreetName());
        address.setPostalCode(newAddress.getPostalCode());
        address.setCity(newAddress.getCity());

        // If the user address is created correctly, it will return the 201 Http response code
        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(address));
    }

    /**
     * Method to edit a user address.
     *
     * @param editAddress New address data.
     * @param id Address identifier.
     * @return 200 OK if edited successfully, 404 Not Found if not.
     */
    @PutMapping("/address/{id}")
    public ResponseEntity<?> editAddress(@RequestBody AddressDTO editAddress, @PathVariable Long id) {
        // This looks for the user address by id to edit the attributes
        return addressRepository.findById(id).map(userAddress -> {

            // We put the new information
            userAddress.setKindOfStreet(editAddress.getKindOfStreet());
            userAddress.setStreetName(editAddress.getStreetName());
            userAddress.setPostalCode(editAddress.getPostalCode());
            userAddress.setCity(editAddress.getCity());

            // If the user address edits correctly, it will return the 200 Http response code
            return ResponseEntity.ok(addressRepository.save(userAddress));

            // If the user address edits incorrectly, it will return the 404 Http response code
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method to delete an address by ID
     *
     * @param id Address identifier.
     * @return 202 No Content if the address was successfully deleted, 404 Not Found if the address was not found.
     */
    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        // If the id exists, we will delete the user address and get the 202 http response code
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // If it doesn't exist, we will get the 404 http response code (Not found)
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
