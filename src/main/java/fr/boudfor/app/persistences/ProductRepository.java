package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Optional<Product> findById(Long id);
}