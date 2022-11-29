package org.iesvi.isara.gestionUsuario.infra.persistence;

import org.iesvi.isara.gestionUsuario.domain.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
}
