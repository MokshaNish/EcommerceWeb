package com.moksha.ecommerceweb.Controllers;

import com.moksha.ecommerceweb.Models.Cart;
import com.moksha.ecommerceweb.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartRepository cartrepo;

    @GetMapping("/{id}")
    public Optional<Cart> get(@PathVariable int id){
        return cartrepo.findById(id);
    }

    @GetMapping
    public List<Cart> getAll(){
        return cartrepo.findAll();
    }

    @PostMapping
    public Cart add(@RequestBody Cart cart){
        return cartrepo.save(cart);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        cartrepo.deleteById(id);
    }


}
