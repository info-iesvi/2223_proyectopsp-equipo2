package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isa González & Sara Palma
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
