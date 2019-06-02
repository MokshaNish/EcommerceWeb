package com.moksha.ecommerceweb.Controllers;

import com.moksha.ecommerceweb.Models.Product;
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

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable int id){
        return productrepo.findById(id);
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productrepo.findAll();
    }

    @PostMapping("/all")
    public Product add(@RequestBody Product product){
        return productrepo.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        productrepo.deleteById(id);
    }




}
