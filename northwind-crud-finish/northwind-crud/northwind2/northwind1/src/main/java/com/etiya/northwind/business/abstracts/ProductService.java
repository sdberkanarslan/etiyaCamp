package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.product.CreateProductRequest;
import com.etiya.northwind.business.responses.product.ProductListResponse;
import com.etiya.northwind.business.requests.product.UpdateProductRequest;
import com.etiya.northwind.entities.concretes.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductListResponse> getAlL();

    ProductListResponse getProductById(String productId);
    Product findProductById(Integer productId);

    ProductListResponse createProduct(CreateProductRequest createProductRequest);

    void deleteProductById(String productId);

    ProductListResponse updateProduct(String productId, UpdateProductRequest updateProductRequest);

    Map<String, Object> findByPageable(int page, int size);

    Map<String, Object> getAllPagesProductByEntity(int pageNumber, int pageSize, String property, String orElse);
}
