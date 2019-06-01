package com.moksha.ecommerceweb.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchaseItem")
    private List<OrderItem> orderItem;


}
