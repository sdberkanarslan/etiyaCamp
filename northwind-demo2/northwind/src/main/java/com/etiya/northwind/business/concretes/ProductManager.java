package com.etiya.northwind.business.concretes;


import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.exception.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.ProductRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
	private ProductRepository productRepository;
	private ModelMapperService modelMapperService;

	@Autowired
	public ProductManager(ProductRepository productRepository,ModelMapperService modelMapperService) {
		this.modelMapperService=modelMapperService;
		this.productRepository = productRepository;
	}

	@Override
	public Result add(CreateProductRequest createProductRequest) {
		checkProductCount(createProductRequest.getCategoryId());
		checkIfProductNameExist(createProductRequest.getProductName());


		Product product=this.modelMapperService.forRequest().map(createProductRequest,Product.class);
		productRepository.save(product);
		return new SuccessResult("PRODUCT ADDED");

	}

	@Override
	public Result update(UpdateProductRequest updateProductRequest) {

		checkIfProductNameExist(updateProductRequest.getProductName());
		Product product=this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
		productRepository.save(product);
		return new SuccessResult("PRODUCT UPDATED");
	}

	@Override
	public Result delete(DeleteProductRequest deleteProductRequest) {

		this.productRepository.deleteById(deleteProductRequest.getProductId());
		return new SuccessResult("PRODUCT DELETED");
	}

	@Override
	public DataResult<GetProductByIdResponse> getById(int id) {
		Product product=this.productRepository.findById(id);
		GetProductByIdResponse getProductByIdResponse=this.modelMapperService.forResponse().map(product,GetProductByIdResponse.class);
		return new SuccessDataResult<GetProductByIdResponse>(getProductByIdResponse);
	}

	@Override
	public DataResult<List<ProductListResponse>> getAll() {
		List<Product> result = this.productRepository.findAll();
		List<ProductListResponse> response = result.stream().map(product->this.modelMapperService.forResponse()
				.map(product,ProductListResponse.class)).collect(Collectors.toList());

		return new SuccessDataResult<List<ProductListResponse>>(response);
	}

	@Override
	public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
		Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
		Map<String,Object> response=new HashMap<>();

		Page<Product> products =productRepository.findAll(pageable);
		response.put("totalElements",products.getTotalElements()) ;
		response.put("totalPages",products.getTotalPages());
		response.put("currentPage",products.getNumber()+1);
		response.put("products",products.getContent().stream().map(product ->
				this.modelMapperService.forResponse().map(product, ProductListResponse.class)).collect(Collectors.toList()));

		return response ;
	}

	@Override
	public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
		Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));
		Map<String,Object> response=new HashMap<>();
		Page<Product>products =productRepository.findAll(pageable);
		response.put("totalElements",products.getTotalElements()) ;
		response.put("totalPages",products.getTotalPages());
		response.put("currentPage",products.getNumber()+1);
		response.put("products",products.getContent().stream().map(product ->
				this.modelMapperService.forResponse().map(product, ProductListResponse.class)).collect(Collectors.toList()));

		return response ;
	}
	public Sort sortType(String property, String type){
		if(type.equals("desc"))
			return Sort.by(property).descending();
		else return Sort.by(property).ascending() ;

	}
	@Override
	public Product findById(int id) {
		return this.productRepository.findById(id);

	}

	private void checkProductCount(int id){
		List<Product> products=productRepository.findByCategoryCategoryId(id);
		if(products.size()>14)
		{
			throw new BusinessException("Category limit exceeded");
		}

	}


	private void checkIfProductNameExist(String name) {
		Product product = productRepository.findByProductName(name);
		if(product != null) {
			throw new BusinessException("Product Exist");
		}
	}


}
