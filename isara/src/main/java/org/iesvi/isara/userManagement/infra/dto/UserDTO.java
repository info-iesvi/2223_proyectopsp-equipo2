package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.shared.domain.UserAddress;

/**
 * The UserDTO has the information about the
 * user
 *
 * @author Isa González & Sara Palma
 */
@Getter
@Setter
public class UserDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserAddress address;
    private String phoneNumber;
    private String email;
}
