package com.moksha.ecommerceweb.Services;

import com.moksha.ecommerceweb.Models.OrderItem;
import com.moksha.ecommerceweb.Repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {


    @Autowired
    OrderItemRepository orderItemRepo;
    //OrderItemRepository orderItemRepo;


//    public ResponseEntity<List<OrderItem>> getAllUserAndStatus(int id) {
//        try {
//
//           List<OrderItem> orderitem = null ;//= orderItemRepo.findByUserIdAndStatus(id, "Pending");
//
////        }
//            return new ResponseEntity(orderitem, HttpStatus.OK);
//            // return orderItemRepo.findByUserIdAndStatus();
//
//        } catch (Exception ex) {
//            return new ResponseEntity("Internal Server Error/n", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
//            List<OrderItem> orderitem = orderItemRepo.findByUser_IdAndStatus(user)
//        for(int i=0; i<orderitem.size(); i++){
//            System.out.println(orderitem.get(i).getProduct().getName().toString());