package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends JpaRepository<Address, Long> {
}