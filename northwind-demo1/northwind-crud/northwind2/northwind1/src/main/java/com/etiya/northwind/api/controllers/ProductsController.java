package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.product.CreateProductRequest;
import com.etiya.northwind.business.responses.product.ProductListResponse;
import com.etiya.northwind.business.requests.product.UpdateProductRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<ProductListResponse> getAll() {
        return this.productService.getAlL();
    }

    @GetMapping("/{productId}")
    public ProductListResponse getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public ProductListResponse createProduct(@RequestBody CreateProductRequest createProductRequest)
    {
        return productService.createProduct(createProductRequest);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable String productId){
        productService.deleteProductById(productId);
    }

    @PutMapping("/{productId}")
    public ProductListResponse updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest updateProductRequest) {
        return productService.updateProduct(productId, updateProductRequest);
    }

    @GetMapping("/getAllWithPaging")
    public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return this.productService.findByPageable(page-1,size);

    }
    @GetMapping("/getallpagesproductbyproperty")
    public Map<String,Object> getAllPagesProductByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

        return this.productService.getAllPagesProductByEntity(pageNumber,pageSize, property,type.orElse(""));

    }
}
