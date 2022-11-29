package org.iesvi.isara.gestionUsuario.infra.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDTO {
    private String userName;
    private String password;
    private String email;
}
