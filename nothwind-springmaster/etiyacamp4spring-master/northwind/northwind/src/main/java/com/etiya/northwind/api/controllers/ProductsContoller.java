package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductsContoller {
    private final ProductService productService;

    public ProductsContoller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<ProductListResponse> getAll() {
        return this.productService.getAlL();
    }
}
