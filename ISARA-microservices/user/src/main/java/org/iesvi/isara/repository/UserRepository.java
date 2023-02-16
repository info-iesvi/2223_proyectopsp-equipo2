package org.iesvi.isara.repository;

import org.iesvi.isara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<User, Long>
 *
 * @author Isa & Sara
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
