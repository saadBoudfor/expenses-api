package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StoreRepository  extends JpaRepository<Store, Long> {
}