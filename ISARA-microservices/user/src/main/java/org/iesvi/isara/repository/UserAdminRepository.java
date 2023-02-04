package org.iesvi.isara.repository;

import org.iesvi.isara.model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserAdmin, Long>
 *
 * @author Isa & Sara
 */
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}
