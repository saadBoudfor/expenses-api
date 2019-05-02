package fr.boudfor.app.web;

import fr.boudfor.app.domain.Product;
import fr.boudfor.app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expenses/products")
@AllArgsConstructor
public class ProductController {

    private ProductService _productService;

    @GetMapping("/all")
    public Product[] getAll() {
        return this._productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findByID(@PathVariable(value = "id") final Long id) {
        return this._productService.findById(id);
    }

}