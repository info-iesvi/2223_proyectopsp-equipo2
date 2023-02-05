package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.model.UserAddress;

/**
 * The UserCustomerDTO has the information about the user customer.
 *
 * @author Isa & Sara
 */
@Getter
@Setter
public class UserCustomerDTO {
    private Long idUser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserAddress address;
    private String phoneNumber;
    private String email;
}
