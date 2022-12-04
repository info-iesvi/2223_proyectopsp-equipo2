package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.shared.domain.UserAddress;

/**
 *
 * @author Isa González
 */
@Getter
@Setter
public class UpdateUserDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private UserAddress address;
    private String phoneNumber;
    private String email;
}
