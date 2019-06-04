package com.moksha.ecommerceweb.Repositories;

import com.moksha.ecommerceweb.Models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    void deleteById(OrderItem orderItem);

    Optional<OrderItem> findByCartIdAndProductPid(int cartId, int productPid);

    //@Query("SELECT o from OrderItem o where o.status='Pending'")
    //  List<OrderItem> findByUserIdAndStatus();

//    List<OrderItem> findByUserIdAndStatus(int userId, String status);


}
