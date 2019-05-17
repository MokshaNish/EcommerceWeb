package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

