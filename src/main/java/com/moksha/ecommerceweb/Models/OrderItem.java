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
    private int quantity;


    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("orderItems")
    private Cart cart;

    @ManyToOne
    @JoinColumn
    private Product product;



}
