package org.iesvi.isara.userManagement.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Isa González
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