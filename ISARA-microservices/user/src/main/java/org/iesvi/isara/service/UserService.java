package org.iesvi.isara.service;

import org.iesvi.isara.model.User;
import org.iesvi.isara.model.UserEmail;
import org.iesvi.isara.model.dto.UserAccessDTO;
import org.iesvi.isara.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the User Entity.
 * This serves as an intermediary between the User class and the UserController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface UserService {

    /**
     * Method to list all the users of the repository.
     *
     * @return A list of users.
     */
    List<UserDTO> getAllUsers();

    /**
     * Method to display the data of a user by id.
     *
     * @param id Identification of user.
     * @return The data of the user.
     */
    UserDTO getUserById(Long id);

    /**
     * Method to save the data of the user in the repository.
     * This method will be used both to create a new user and to edit an exiting one.
     *
     * @param user The user's data.
     * @return The data of the user saved.
     */
    UserDTO saveUser(User user);

    /**
     * Method to delete a user by id.
     *
     * @param id Identification of user to delete.
     */
    void deleteUser(Long id);

    /**
     * Method to email to the server Gmail account.
     *
     * @param email
     */
    void sendEmail(UserEmail email);
}
