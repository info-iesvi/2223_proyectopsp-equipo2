package org.iesvi.isara.service.impl;

import org.iesvi.isara.model.User;
import org.iesvi.isara.model.dto.UserDTO;
import org.iesvi.isara.model.dto.converter.UserDTOConverter;
import org.iesvi.isara.repository.UserRepository;
import org.iesvi.isara.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the User Entity.
 * This serves as an intermediary between the User class and the UserController controller.
 *
 * @author Isa & Sara
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return UserDTOConverter.convertListToDto(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserDTOConverter.convertToDto(userRepository.findById(id));
    }

    @Override
    public UserDTO saveUser(User user) {
        return UserDTOConverter.convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
