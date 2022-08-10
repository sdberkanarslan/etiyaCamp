package com.etiya.northwind.business.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {

    private int productId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
    private String categoryName;
    private String contactName;
}
