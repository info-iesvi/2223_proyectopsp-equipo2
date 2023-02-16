package org.iesvi.isara.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Child class that extends the user class.
 *
 * @author Isa & Sara
 */
@Entity
@Data
@NoArgsConstructor
public class UserCustomer extends User {
}
