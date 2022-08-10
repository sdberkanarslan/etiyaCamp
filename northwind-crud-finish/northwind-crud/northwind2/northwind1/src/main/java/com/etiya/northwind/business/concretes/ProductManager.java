package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.product.CreateProductRequest;
import com.etiya.northwind.business.responses.product.ProductListResponse;
import com.etiya.northwind.business.requests.product.UpdateProductRequest;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.sort.SortingEntities;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Override
    public ProductListResponse getProductById(String productId) {
        Product product = productRepository.findById(Integer.valueOf(productId)).orElse(null);

        if (product == null) {
            return null;
        }
        return this.modelMapperService.forResponse().map(product, ProductListResponse.class);

    }

    @Override
    public Product findProductById(Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("bulunamadi"));

        if (product == null) {
            return null;
        }
        return product;

    }


    @Override
    public ProductListResponse createProduct(CreateProductRequest createProductRequest) {

        Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);

        productRepository.save(product);

        return this.modelMapperService.forResponse().map(product, ProductListResponse.class);
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.deleteById(Integer.valueOf(productId));
    }

    @Override
    public ProductListResponse updateProduct(String productId, UpdateProductRequest updateProductRequest) {

        Product product = productRepository.findById(Integer.valueOf(productId)).orElse(null);
        if (product == null) {
            return null;
        }
        Product product2 = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        product2.setProductId(product.getProductId());
        product2.setCategory(product.getCategory());
        product2.setSupplier(product.getSupplier());

        productRepository.save(product2);
        return this.modelMapperService.forResponse().map(product2, ProductListResponse.class);

    }


    @Override
    public Map<String, Object> findByPageable(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Product> result = productRepository.findAll(pageable);
        List<Product> products = result.getContent();
        List<ProductListResponse> productListResponses =
                products
                        .stream()
                        .map(product ->
                                this.modelMapperService.forResponse().map(product, ProductListResponse.class))
                        .collect(Collectors.toList());


        Map<String, Object> response = new HashMap<>();
        response.put("Products",productListResponses);
        response.put("CurrentPage",result.getNumber()+1);
        response.put("Total Items",result.getTotalElements());
        response.put("Total Pages",result.getTotalPages());

        return response;
    }

    @Override
    public Map<String, Object> getAllPagesProductByEntity(int pageNumber, int pageSize,String property,String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize, SortingEntities.sortType(property,type));



        Page<Product>result =productRepository.findAll(pageable);
        Map<String,Object> response=new HashMap<>();
        response.put("totalElements",result.getTotalElements()) ;
        response.put("totalPages",result.getTotalPages());
        response.put("currentPage",result.getNumber()+1);
        response.put("result",result.getContent().stream().map(product ->
                this.modelMapperService.forResponse().map(product,ProductListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
}
