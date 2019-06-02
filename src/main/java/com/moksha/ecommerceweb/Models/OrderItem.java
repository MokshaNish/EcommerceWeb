package com.moksha.ecommerceweb.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private int quantity;
    private int user_Id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_pid")
    @JsonIgnoreProperties({"hibernateLazyInitializer","orderItemList"})
    private Product product;
}
