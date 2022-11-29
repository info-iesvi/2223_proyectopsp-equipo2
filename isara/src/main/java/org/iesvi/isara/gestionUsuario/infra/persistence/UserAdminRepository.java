package org.iesvi.isara.gestionUsuario.infra.persistence;

import org.iesvi.isara.gestionUsuario.domain.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
}
