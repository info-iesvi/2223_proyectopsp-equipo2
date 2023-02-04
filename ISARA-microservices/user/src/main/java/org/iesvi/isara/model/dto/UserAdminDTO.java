package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.model.UserAddress;

/**
 * The UserAdminDTO has the information about the user admin.
 *
 * @author Isa & Sara
 */
@Getter
@Setter
public class UserAdminDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserAddress address;
    private String phoneNumber;
    private String email;
    private Double salary;
}
