package org.iesvi.isara.shared.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Auxiliary class to store user addresses.
 *
 * @author Isa & Sara
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idAddress;

    private String kindOfStreet;
    private String streetName;
    private Integer postalCode;
    private String city;

    /**
     *
     * @return the adress of the user's id
     */
    public Long getIdAddress() {
        return idAddress;
    }

    /**
     *
     * @param idAddress
     */
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
