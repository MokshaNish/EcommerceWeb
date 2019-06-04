package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

   Optional<Cart> findByUserIdAndStatus(int userId, String status);
}
