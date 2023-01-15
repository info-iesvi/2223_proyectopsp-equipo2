package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserAdmin, Long>
 *
 * @author Isa & Sara
 */
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}
