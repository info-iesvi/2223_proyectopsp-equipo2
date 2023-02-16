package org.iesvi.isara.service;

import org.iesvi.isara.model.UserAddress;
import org.iesvi.isara.model.dto.UserAddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserAddress Entity.
 * This serves as an intermediary between the UserAddress class and the UserAddressController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface UserAddressService {

    /**
     * Method to list the users address of the repository.
     *
     * @return A list of addresses.
     */
    List<UserAddressDTO> getAllUserAddress();

    /**
     * Method to display the data of a user address by id.
     *
     * @param id Identification of user address.
     * @return The data of the address.
     */
    UserAddressDTO getUserAddressById(Long id);

    /**
     * Method to save the data of the user address in the repository.
     * This method will be used both to create a new user address and to edit an exiting one.
     *
     * @param address The user address' data.
     * @return The data of the address saved.
     */
    UserAddressDTO saveUserAddress(UserAddress address);

    /**
     * Method to delete a user address by id.
     *
     * @param id Identification of user address to delete.
     */
    void deleteUserAddress(Long id);
}
