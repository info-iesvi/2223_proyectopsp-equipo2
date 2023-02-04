package org.iesvi.isara.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Class to transmit address information.
 *
 * @author Isa & Sara
 */
@Getter
@Setter
public class UserAddressDTO {
    private Long idAddress;
    private String kindOfStreet;
    private String streetName;
    private Integer postalCode;
    private String city;
}
