package fr.boudfor.app.services;

import fr.boudfor.app.domain.Product;
import fr.boudfor.app.persistences.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductService implements IProductService {
    private ProductRepository repository;
    @Override
    public Product[] getAll() {
       return this.repository.findAll().toArray(new Product[0]);
    }
}