package org.iesvi.isara.model;

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
     * Get method for idAddress.
     *
     * @return The address of the user's identification
     */
    public Long getIdAddress() {
        return idAddress;
    }

    /**
     * Set method for idAddress.
     *
     * @param idAddress Identification address to change
     */
    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
