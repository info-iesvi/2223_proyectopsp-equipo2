package org.iesvi.isara.userManagement.service;

import org.iesvi.isara.userManagement.domain.User;
import org.iesvi.isara.userManagement.infra.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Isa & Sara
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param user
     * @return a user that we can save in the userRepository
     */
     public User saveUser(User user) { return userRepository.save(user); }

    /**
     *
     * @return all the users that are registered in the userRepository
     */
     public List<User> getAllUsers() { return userRepository.findAll(); }

    /**
     *
     * @param id
     */
     public void deleteUser(Long id) { userRepository.deleteById(id); }
}
