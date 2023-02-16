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

    @Override
    public List<UserAddressDTO> getAllUserAddress() {
        return UserAddressDTOConverter.convertListToDto(userAddressRepository.findAll());
    }

    @Override
    public UserAddressDTO getUserAddressById(Long id) {
        return UserAddressDTOConverter.convertToDto(userAddressRepository.findById(id));
    }

    @Override
    public UserAddressDTO saveUserAddress(UserAddress address) {
        return UserAddressDTOConverter.convertToDto(userAddressRepository.save(address));
    }

    @Override
    public void deleteUserAddress(Long id) {
        userAddressRepository.deleteById(id);
    }
}
