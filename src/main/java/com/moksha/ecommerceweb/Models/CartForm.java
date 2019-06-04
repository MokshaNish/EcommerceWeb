package com.moksha.ecommerceweb.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartForm {

    private int cartId;
    private Product product;
    private int quantity;

}
