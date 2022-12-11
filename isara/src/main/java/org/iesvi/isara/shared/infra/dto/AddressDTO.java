package org.iesvi.isara.shared.infra.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Isa González
 */

@Getter
@Setter
public class AddressDTO {
    private String kindOfStreet;
    private String streetName;
    private Integer postalCode;
    private String city;
}
