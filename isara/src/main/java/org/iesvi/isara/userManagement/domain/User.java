package org.iesvi.isara.userManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.iesvi.isara.shared.domain.UserAddress;

/**
 * User parent class with common attributes for all users who will use the application.
 *
 * @author Isa González
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private Long idUser;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private UserAddress address;
    private String phoneNumber;
    private String email;
}
