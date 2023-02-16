package org.iesvi.isara.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class will help us to send an email.
 *
 * @author Isa & Sara
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmail {
    private String subject;
    private String message;
}
