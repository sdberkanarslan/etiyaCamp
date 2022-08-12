package com.etiya.northwind.business.abstracts;

import java.util.List;
import java.util.Map;

import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.entities.concretes.Product;

public interface ProductService {
	Result add(CreateProductRequest createProductRequest);
	Result update(UpdateProductRequest updateProductRequest);
	Result delete(DeleteProductRequest deleteProductRequest);
	DataResult <GetProductByIdResponse> getById(int id);
	DataResult <List<ProductListResponse>>getAll();

	Map<String,Object> getAllPages(int pageNumber, int pageSize);

	Map<String,Object>getAllPagesOrderByEntity(int pageNumber, int pageSize,String entity,String type);

    Product findById(int id);
}
