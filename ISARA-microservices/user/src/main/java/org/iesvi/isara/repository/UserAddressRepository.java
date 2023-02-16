package org.iesvi.isara.repository;

import org.iesvi.isara.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository<UserAddress, Long>.
 *
 * @author Isa González & Sara Palma
 */
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
