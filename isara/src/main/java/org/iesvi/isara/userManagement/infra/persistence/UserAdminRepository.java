package org.iesvi.isara.userManagement.infra.persistence;

import org.iesvi.isara.userManagement.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Isa González
 */
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}