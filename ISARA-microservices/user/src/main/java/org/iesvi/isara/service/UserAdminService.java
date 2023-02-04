package org.iesvi.isara.service;

import org.iesvi.isara.model.UserAdmin;
import org.iesvi.isara.model.dto.UserAdminDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserAdmin Entity.
 * This serves as an intermediary between the UserAdmin class and the UserAdminController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface UserAdminService {

    /**
     * Method to list all the user admins of the repository.
     *
     * @return A list of user admins.
     */
    List<UserAdminDTO> getAllUserAdmins();

    /**
     * Method to display the data of a user admin by id.
     *
     * @param id Identification of user admin.
     * @return The data of the user admin.
     */
    UserAdminDTO getUserAdminById(Long id);

    /**
     * Method to save the data of the user admin in the repository.
     * This method will be used both to create a new user and to edit an exiting one.
     *
     * @param userAdmin The user admin's data.
     * @return The data of the user admin saved.
     */
    UserAdminDTO saveUserAdmin(UserAdmin userAdmin);

    /**
     * Method to delete a user admin by id.
     *
     * @param id Identification of user admin to delete.
     */
    void deleteUserAdmin(Long id);
}
