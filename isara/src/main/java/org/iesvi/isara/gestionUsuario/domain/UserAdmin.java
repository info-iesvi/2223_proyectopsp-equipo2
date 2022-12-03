package org.iesvi.isara.gestionUsuario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Child class that extends the user class.
 */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserAdmin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_admin", nullable = false)
    private Integer idAdmin;
    private Double salary;

    @JoinColumn(name = "user_id")
    private Integer userId;
}
