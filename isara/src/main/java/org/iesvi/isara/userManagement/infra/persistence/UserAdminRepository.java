package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserAdmin, Long>
 *
 * @author Isa González & Sara Palma
 */
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}
