package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserCustomer, Long>
 *
 * @author Isa & Sara
 */
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
