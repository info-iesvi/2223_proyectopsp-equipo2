package org.iesvi.isara.service;

import org.iesvi.isara.model.UserCustomer;
import org.iesvi.isara.model.dto.UserCustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer of the UserCustomer Entity.
 * This serves as an intermediary between the UserCustomer class and the UserCustomerController controller.
 *
 * @author Isa & Sara
 */
@Service
public interface UserCustomerService {

    /**
     * Method to list all the user customers of the repository.
     *
     * @return A list of user customers.
     */
    List<UserCustomerDTO> getAllUserCustomers();

    /**
     * Method to display the data of a user customer by id.
     *
     * @param id Identification of user customer.
     * @return The data of the user customer.
     */
    UserCustomerDTO getUserCustomerById(Long id);

    /**
     * Method to save the data of the user customer in the repository.
     * This method will be used both to create a new user and to edit an exiting one.
     *
     * @param userCustomer The user customer's data.
     * @return The data of the user customer saved.
     */
    UserCustomerDTO saveUserCustomer(UserCustomer userCustomer);

    /**
     * Method to delete a user customer by id.
     *
     * @param id Identification of user customer to delete.
     */
    void deleteUserCustomer(Long id);
}
