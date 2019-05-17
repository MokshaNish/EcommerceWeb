package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
