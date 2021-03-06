package com.moksha.ecommerceweb.Controllers;

import com.moksha.ecommerceweb.Models.Cart;
import com.moksha.ecommerceweb.Models.CartForm;
import com.moksha.ecommerceweb.Models.OrderItem;
import com.moksha.ecommerceweb.Repositories.CartRepository;
import com.moksha.ecommerceweb.Repositories.OrderItemRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartRepository cartrepo;

    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping("/{id}")
    public Optional<Cart> get(@PathVariable int id) {
        return cartrepo.findById(id);
    }

    @DeleteMapping("order-product/{id}")
    public void deleteOrderItem(@PathVariable int id) {
        orderItemRepository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    public Cart deleteCart(@PathVariable int id) {
        Optional<Cart> cart= cartrepo.findById(id);

        if(cart.isPresent()) {
            Cart c = cart.get();
            c.setStatus("Purchased");
            return cartrepo.save(c);
        }

        return null;
    }

    @GetMapping("/user-id/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) {

        Optional<Cart> c = cartrepo.findByUserIdAndStatus(userId, "Pending");

        if (c.isPresent()) {
            return c.get();
        } else {
            Cart cart = new Cart();
            cart.setUserId(userId);
            return cartrepo.save(cart);
        }
    }

    @GetMapping("/order-history/{userId}")
    public Optional <List<Cart>> getHistory(@PathVariable int userId){

        return cartrepo.findAllByUserIdAndStatus(userId,"Purchased");
    }




    @GetMapping
    public List<Cart> getAll() {
        return cartrepo.findAll();
    }

    @GetMapping("/all")
    public List<OrderItem> getAllCartItems() {
        return orderItemRepository.findAll();
    }


    @PostMapping("/add")
    public OrderItem addToCart(@RequestBody CartForm cartForm) {

        Optional<Cart> c = cartrepo.findById(cartForm.getCartId());

        if (c.isPresent()) {
            Cart cart = c.get();

    Optional<OrderItem> orderItemOptional = orderItemRepository.findByCartIdAndProductPid(cartForm.getCartId(), cartForm.getProduct().getPid());

            if (orderItemOptional.isPresent()) {
                OrderItem orderItem = orderItemOptional.get();

                orderItem.setQuantity(orderItem.getQuantity() + cartForm.getQuantity());
                orderItemRepository.save(orderItem);
            } else {
                OrderItem orderItem = new OrderItem();
                orderItem.setCart(cart);
                orderItem.setProduct(cartForm.getProduct());
                orderItem.setQuantity(cartForm.getQuantity());
                return orderItemRepository.save(orderItem);
            }
        }
        return null;
    }



}
