package com.etiya.northwind.business.responses.products;

import com.etiya.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdResponse {
    private int productId;

    private int supplierId;

    private int categoryId;

    private int discontinued;

    private String productName;

    private double unitPrice;

    private int unitsInStock;

    private String categoryName;


}
