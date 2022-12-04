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
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserAdmin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_admin", nullable = false)
    private Long idAdmin;
    private Double salary;

    @JoinColumn(name = "user_id")
    private Integer userId;
}
