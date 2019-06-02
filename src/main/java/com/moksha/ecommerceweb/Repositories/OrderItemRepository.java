package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Query("SELECT o from OrderItem o where o.status='Pending' AND o.user_Id ='1'")
    public List<OrderItem> findByUserIdAndStatus();



}
