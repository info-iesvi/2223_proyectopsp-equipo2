package org.iesvi.isara.model.dto.converter;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.model.UserAddress;
import org.iesvi.isara.model.dto.UserAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * It converts the class AddressDTO into a modelMapper map.
 *
 * @author Isa & Sara
 */
@Component
@RequiredArgsConstructor
public class UserAddressDTOConverter {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserAddressDTO convertToDto(UserAddress address) {
        return modelMapper.map(address, UserAddressDTO.class);
    }

    public static List<UserAddressDTO> convertListToDto(List<UserAddress> userAddressesDB) {
        List<UserAddressDTO> userAddresses = new ArrayList<>();
        for (UserAddress address : userAddressesDB) {
            userAddresses.add(modelMapper.map(address, UserAddressDTO.class));
        }
        return userAddresses;
    }

    public static UserAddressDTO convertToDto(Optional<UserAddress> addressById) {
        return modelMapper.map(addressById, UserAddressDTO.class);
    }
}
