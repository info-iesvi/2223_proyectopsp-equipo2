package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
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
