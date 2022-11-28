package org.iesvi.isara.gestionUsuario.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvi.isara.shared.domain.Address;

/**
 * User parent class with common attributes for all users who will use the application.
 */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id_address")
    private Address address;
    private String phoneNumber;
    private String email;
}
