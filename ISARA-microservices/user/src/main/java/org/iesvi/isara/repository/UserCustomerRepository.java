package org.iesvi.isara.repository;

import org.iesvi.isara.model.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserCustomer, Long>
 *
 * @author Isa & Sara
 */
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
