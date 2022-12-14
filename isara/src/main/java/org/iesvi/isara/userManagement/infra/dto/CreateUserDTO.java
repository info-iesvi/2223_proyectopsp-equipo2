package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * This class saves all the information about the UserDTO
 *
 * @author Isa González & Sara Palma
 */
@Getter
@Setter
public class CreateUserDTO {
    private String userName;
    private String password;
    private String email;
}
