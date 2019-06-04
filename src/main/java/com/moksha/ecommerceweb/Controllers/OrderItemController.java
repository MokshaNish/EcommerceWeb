package com.moksha.ecommerceweb.Controllers;


import com.moksha.ecommerceweb.Models.OrderItem;
import com.moksha.ecommerceweb.Repositories.OrderItemRepository;
import com.moksha.ecommerceweb.Services.OrderItemService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepo;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/{id}")
    public Optional<OrderItem> get(@PathVariable int id) {

        return orderItemRepo.findById(id);
    }

    @GetMapping
    public List<OrderItem> getAll() {


        return orderItemRepo.findAll();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<OrderItem>> getAllUserAndStatus(@PathVariable int id) {
//        return orderItemService.getAllUserAndStatus(id);
//
//    }

    @PostMapping
    public OrderItem addProductToCart(@RequestBody OrderItem cartItem) {

        return orderItemRepo.save(cartItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderItemRepo.deleteById(id);
    }
}
