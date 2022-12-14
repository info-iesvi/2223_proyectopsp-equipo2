package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This class transmits User Admin information
 *
 * @author Isa González & Sara Palma
 */
@Getter
@Setter
public class CreateUserAdminDTO {
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
}
