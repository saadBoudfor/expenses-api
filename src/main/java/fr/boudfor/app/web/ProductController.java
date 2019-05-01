package fr.boudfor.app.web;

import fr.boudfor.app.domain.Product;
import fr.boudfor.app.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/")
    public Product[] getAll() {
        return this.productService.getAll();
    }

}