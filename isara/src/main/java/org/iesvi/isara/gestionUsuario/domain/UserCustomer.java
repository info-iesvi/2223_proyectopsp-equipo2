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
public class UserCustomer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @JoinColumn(name = "user_id")
    private Integer userId;
}
