package com.etiya.northwind.business.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDetailRequest {
    private int unitPrice;
    private int quantity;
    private int discount;
}
