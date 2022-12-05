package org.iesvi.isara.userManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Child class that extends the user class.
 *
 * @author Isa González
 */
@Entity
@Table(name = "userCustomer")
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserCustomer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @JoinColumn(name = "user_id")
    private Integer userId;
}
