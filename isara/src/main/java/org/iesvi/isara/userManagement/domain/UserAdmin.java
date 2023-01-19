package org.iesvi.isara.userManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Child class that extends the user class.
 *
 * @author Isa & Sara
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdmin extends User {
    private Double salary;
}
