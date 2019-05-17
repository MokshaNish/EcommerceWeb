package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

