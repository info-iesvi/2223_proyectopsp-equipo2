package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.shared.infra.dto.AddressDTO;

/**
 *
 * @author Isa González & Sara Palma
 */
@Getter
@Setter
public class UpdateUserDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private String phoneNumber;
    private String email;
}
