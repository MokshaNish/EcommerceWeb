package com.moksha.ecommerceweb.Controllers;

import com.moksha.ecommerceweb.Models.Category;
import com.moksha.ecommerceweb.Models.Product;
import com.moksha.ecommerceweb.Repositories.CategoryRepository;
import com.moksha.ecommerceweb.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productrepo;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable int id) {
        return productrepo.findById(id);
    }

    @GetMapping("/all")
    public Optional <List<Product>> getAll() {
        return productrepo.findAllByStatus("Available");
    }

    @PostMapping()
    public Product add(@RequestBody Product product) {
        Optional<Category> categoryOptional = categoryRepository.findById(product.getCategory().getCategoryId());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            product.setCategory(category);
            return productrepo.save(product);
        }
        return product;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productrepo.deleteById(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productrepo.save(product);
    }
}
