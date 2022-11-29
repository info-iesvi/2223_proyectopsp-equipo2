package org.iesvi.isara.gestionUsuario.infra.persistence;

import org.iesvi.isara.gestionUsuario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
