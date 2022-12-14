package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserCustomer, Long>
 *
 * @author Isa González & Sara Palma
 */
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
