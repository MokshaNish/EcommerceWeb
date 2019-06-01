package com.moksha.ecommerceweb.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity

@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private int quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem")
    private List<Product> product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseItem_id")
    private PurchaseItem purchaseItem;





}
