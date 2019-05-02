package fr.boudfor.app.services;

import fr.boudfor.app.domain.Product;
import fr.boudfor.app.persistences.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductService implements IProductService {
    private ProductRepository _repository;
    @Override
    public Product[] findAll() {
       return this._repository.findAll().toArray(new Product[0]);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> found = this._repository.findById(id);
        return found.isPresent() ? found.get(): null;
    }
}