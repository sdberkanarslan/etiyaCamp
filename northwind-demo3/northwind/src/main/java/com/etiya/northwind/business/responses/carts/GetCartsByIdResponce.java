package com.etiya.northwind.business.responses.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartsByIdResponce {
    private int cartId;
    private int productId;
    private double unitPrice;
    private int quantity;
}
