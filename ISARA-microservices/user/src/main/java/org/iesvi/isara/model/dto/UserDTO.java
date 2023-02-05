package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.model.UserAddress;

/**
 * The UserDTO has the information about the user.
 *
 * @author Isa & Sara
 */
@Getter
@Setter
public class UserDTO {
    private Long idUser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserAddress address;
    private String phoneNumber;
    private String email;
}
