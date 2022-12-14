package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The UserAdminDTO has the information about the user admin.
 *
 * @author Isa González & Sara Palma
 */
@Getter
@Setter
public class UserAdminDTO {
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
}
