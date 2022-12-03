package org.iesvi.isara.gestionUsuario.infra.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.shared.domain.Address;

@Getter
@Setter
public class UpdateUserAdminDTO {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
    private String email;
    private Double salary;
}
