package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Isa González
 */
public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
