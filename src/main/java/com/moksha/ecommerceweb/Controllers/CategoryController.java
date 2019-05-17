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
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryrepo;

    @GetMapping("/{id}")
    public Optional<Category> get(@PathVariable int id){
        return categoryrepo.findById(id);
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryrepo.findAll();
    }

    @PostMapping
    public Category add(@RequestBody Category category){
        return categoryrepo.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryrepo.deleteById(id);
    }
}
