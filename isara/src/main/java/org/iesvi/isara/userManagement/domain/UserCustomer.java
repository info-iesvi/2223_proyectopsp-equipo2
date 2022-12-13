package org.iesvi.isara.userManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Child class that extends the user class.
 *
 * @author Isa González & Sara Palma
 */
@Entity
@Data
@NoArgsConstructor
public class UserCustomer extends User {
}
