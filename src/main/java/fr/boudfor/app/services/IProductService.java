package fr.boudfor.app.services;

import fr.boudfor.app.domain.Product;

public interface IProductService {
    public Product[] findAll();
    public Product findById(Long id);
}