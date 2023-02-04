package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.UserAddress;
import org.iesvi.isara.model.dto.UserAddressDTO;
import org.iesvi.isara.model.dto.converter.UserAddressDTOConverter;
import org.iesvi.isara.repository.UserAddressRepository;
import org.iesvi.isara.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserAddress Entity.
 * This serves as an intermediary between the UserAddress class and the UserAddressController controller.
 *
 * @author Isa & Sara
 */
@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    /**
     * Method to list the user address of the repository.
     *
     * @return A list of address.
     */
    @Override
    public List<UserAddressDTO> getAllUserAddress() {
        return UserAddressDTOConverter.convertListToDto(userAddressRepository.findAll());
    }

    /**
     * Method to display the data of a user address by id.
     *
     * @param id Identification of user address.
     * @return The data of the address.
     */
    @Override
    public UserAddressDTO getUserAddressById(Long id) {
        return UserAddressDTOConverter.convertToDto(userAddressRepository.findById(id));
    }

    /**
     * Method to save the data of the user address in the repository.
     * This method will be used both to create a new user address and to edit an exiting one.
     *
     * @param address The user address' data.
     * @return The data of the address saved.
     */
    @Override
    public UserAddressDTO saveUserAddress(UserAddress address) {
        return UserAddressDTOConverter.convertToDto(userAddressRepository.save(address));
    }

    /**
     * Method to delete a user address by id.
     *
     * @param id Identification of user address to delete.
     */
    @Override
    public void deleteUserAddress(Long id) {
        userAddressRepository.deleteById(id);
    }
}
