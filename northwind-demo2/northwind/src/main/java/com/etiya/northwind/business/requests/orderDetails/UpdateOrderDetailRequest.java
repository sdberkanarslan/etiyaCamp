package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDetailRequest {
    private int orderId;
    private int productId;
    private LocalDate orderDate;
    private double unitPrice;
    private int quantity;
    private double discount;
}
