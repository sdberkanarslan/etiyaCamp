package com.etiya.northwind.business.responses.products;

import com.etiya.northwind.entities.concretes.Category;

import com.etiya.northwind.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {

	private int productId;

	private int categoryId;

	private int supplierId;

	private int discontinued;

	private String productName;

	private double unitPrice;

	private int unitsInStock;


	private String categoryName;


}
