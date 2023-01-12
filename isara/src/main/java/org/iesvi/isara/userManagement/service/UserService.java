package org.iesvi.isara.userManagement.service;

import org.iesvi.isara.userManagement.domain.User;
import org.iesvi.isara.userManagement.infra.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

     public User saveUser(User user) { return userRepository.save(user); }

     public List<User> getAllUsers() { return userRepository.findAll(); }

     public void deleteUser(Long id) { userRepository.deleteById(id); }
}
