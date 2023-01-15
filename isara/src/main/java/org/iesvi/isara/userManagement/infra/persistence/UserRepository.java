package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<User, Long>
 *
 * @author Isa & Sara
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
