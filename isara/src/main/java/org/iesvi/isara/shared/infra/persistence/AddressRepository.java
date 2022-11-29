package org.iesvi.isara.shared.infra.persistence;

import org.iesvi.isara.shared.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
