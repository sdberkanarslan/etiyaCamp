package com.etiya.northwind.business.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private String productName;
    private double unitPrice;
    private int unitsInStock;
}
