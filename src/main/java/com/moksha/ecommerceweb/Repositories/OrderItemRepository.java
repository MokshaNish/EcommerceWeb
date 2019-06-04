package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.OrderItem;
import com.moksha.ecommerceweb.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {


    //@Query("SELECT o from OrderItem o where o.status='Pending'")
    //  List<OrderItem> findByUserIdAndStatus();

//    List<OrderItem> findByUserIdAndStatus(int userId, String status);


}
