package com.etiya.northwind.api.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.products.GetProductByIdResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/products")
public class ProductsController {
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {

		this.productService = productService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody  CreateProductRequest createProductRequest){
		return	this.productService.add(createProductRequest);

	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateProductRequest updateProductRequest){
		return	this.productService.update(updateProductRequest);

	}
	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteProductRequest deleteProductRequest){
		return	this.productService.delete(deleteProductRequest);
	}


	@GetMapping("/getAll")
	public DataResult <List<ProductListResponse>> getAll() {

		return this.productService.getAll();

	}
	@GetMapping("/getbyid")
	public DataResult <GetProductByIdResponse> getById(@RequestParam int id){

		return this.productService.getById(id);
	}

	@GetMapping("/getallpages")
	public Map<String,Object> getAllPages(@RequestParam int pageNumber, @RequestParam int pageSize){

		return this.productService.getAllPages(pageNumber,pageSize);

	}

	@GetMapping("/getallpagesorderbyentity")
	public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String entity,@RequestParam Optional<String> type){

		return this.productService.getAllPagesOrderByEntity(pageNumber,pageSize, entity,type.orElse(""));

	}
}

