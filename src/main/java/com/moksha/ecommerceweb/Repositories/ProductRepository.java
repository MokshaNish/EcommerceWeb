package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
