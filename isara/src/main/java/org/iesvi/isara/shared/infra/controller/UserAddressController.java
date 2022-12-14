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
        return addressRepository.findById(id).map(userAddress -> {
            userAddress.setKindOfStreet(editAddress.getKindOfStreet());
            userAddress.setStreetName(editAddress.getStreetName());
            userAddress.setPostalCode(editAddress.getPostalCode());
            userAddress.setCity(editAddress.getCity());
            return ResponseEntity.ok(addressRepository.save(userAddress));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method to delete an address by ID
     *
     * @param id Address identifier.
     * @return 204 No Content if the address was successfully deleted, 404 Not Found if the address was not found.
     */
    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
