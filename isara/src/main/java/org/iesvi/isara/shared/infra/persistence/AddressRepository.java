package org.iesvi.isara.shared.infra.persistence;

import org.iesvi.isara.shared.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserAddress, Long>
 *
 *
 * @author Isa González & Sara Palma
 */
public interface AddressRepository extends JpaRepository<UserAddress, Long> {
}
