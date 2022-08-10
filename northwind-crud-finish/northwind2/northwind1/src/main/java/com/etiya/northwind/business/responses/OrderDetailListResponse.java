package com.etiya.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailListResponse {

    private int orderId;
    private int productId;
    private int unitPrice;
    private int quantity;
    private int discount;

}
