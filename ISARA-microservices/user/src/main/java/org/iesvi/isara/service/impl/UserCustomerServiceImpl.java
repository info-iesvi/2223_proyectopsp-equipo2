package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.UserCustomer;
import org.iesvi.isara.model.dto.UserCustomerDTO;
import org.iesvi.isara.model.dto.UserDTO;
import org.iesvi.isara.model.dto.converter.UserCustomerDTOConverter;
import org.iesvi.isara.repository.UserCustomerRepository;
import org.iesvi.isara.service.UserCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserCustomer Entity.
 * This serves as an intermediary between the UserCustomer class and the UserCustomerController controller.
 *
 * @author Isa & Sara
 */
@Service
public class UserCustomerServiceImpl implements UserCustomerService {

    @Autowired
    private UserCustomerRepository userCustomerRepository;

    @Override
    public List<UserCustomerDTO> getAllUserCustomers() {
        return UserCustomerDTOConverter.convertListToDto(userCustomerRepository.findAll());
    }

    @Override
    public UserCustomerDTO getUserCustomerById(Long id) {
        return UserCustomerDTOConverter.convertToDto(userCustomerRepository.findById(id));
    }

    @Override
    public UserCustomerDTO saveUserCustomer(UserCustomer userCustomer) {
        return UserCustomerDTOConverter.convertToDto(userCustomerRepository.save(userCustomer));
    }

    @Override
    public void deleteUserCustomer(Long id) {
        userCustomerRepository.deleteById(id);
    }
}
