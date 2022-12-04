package org.iesvi.isara.shared.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auxiliary class to store user addresses.
 *
 * @author Isa González
 */
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address", nullable = false)
    private Long idAddress;

    private String kindOfStreet;
    private String streetName;
    private Integer postalCode;
    private String city;

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
