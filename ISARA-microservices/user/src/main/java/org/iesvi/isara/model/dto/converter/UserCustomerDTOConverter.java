package org.iesvi.isara.model.dto.converter;

import org.iesvi.isara.model.UserCustomer;
import org.iesvi.isara.model.dto.UserCustomerDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This DTO class converts a UserCustomer object to a UserCustomerDTO using the ModelMapper class.
 *
 * @author Isa & Sara
 */
public class UserCustomerDTOConverter {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserCustomerDTO convertToDto(UserCustomer userCustomer) {
        return modelMapper.map(userCustomer, UserCustomerDTO.class);
    }

    public static List<UserCustomerDTO> convertListToDto(List<UserCustomer> userDB) {
        List<UserCustomerDTO> users = new ArrayList<>();
        for (UserCustomer user : userDB) {
            users.add(modelMapper.map(user, UserCustomerDTO.class));
        }
        return users;
    }

    public static UserCustomerDTO convertToDto(Optional<UserCustomer> userById) {
        return modelMapper.map(userById, UserCustomerDTO.class);
    }
}
