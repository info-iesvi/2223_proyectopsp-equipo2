package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.iesvi.isara.controller.UserController;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;
import org.springframework.web.service.invoker.RequestHeaderArgumentResolver;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * This is the DTO class to make the application more secure.
 * In this class we will work with the attributes that will be written in the access.log
 *
 * @author Isa & Sara
 */
@Getter
@Setter
public class UserAccessDTO {
    private String userName;
    private String password;
    private LocalDate date;
    private LocalDateTime time;
    private String resource;
    private String operation;

    UserDTO userDTO = new UserDTO();

    public UserAccessDTO(RequestHeaderMethodArgumentResolver operation, RequestHeaderArgumentResolver resource) {
        this.userName = userDTO.getUserName();
        this.password = userDTO.getPassword();
        this.date = LocalDate.now();
        this.time = LocalDateTime.now();
        this.resource = String.valueOf(resource);
        this.operation = String.valueOf(operation);
    }
}
