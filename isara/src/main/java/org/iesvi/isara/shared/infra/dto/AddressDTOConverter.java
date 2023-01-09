package org.iesvi.isara.shared.infra.dto;

import lombok.RequiredArgsConstructor;
import org.iesvi.isara.shared.domain.UserAddress;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * It converts the class AddressDTO into a modelMapper map
 *
 * @author Isa González & Sara Palma
 */
@Component
@RequiredArgsConstructor
public class AddressDTOConverter {
    private final ModelMapper modelMapper;

    public AddressDTO convertToDto(UserAddress userAddress) {
        return modelMapper.map(userAddress, AddressDTO.class);
    }
}
