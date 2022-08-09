package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {


    private final ProductRepository productRepository;
    private final ModelMapperService modelMapperService;

    public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<ProductListResponse> getAlL() {
        List<Product> result =  this.productRepository.findAll();
        List<ProductListResponse> response = result
                .stream()
                .map(product -> this.modelMapperService.forResponse().map(product,ProductListResponse.class))
                .collect(Collectors.toList());

        return response;
    }
}
