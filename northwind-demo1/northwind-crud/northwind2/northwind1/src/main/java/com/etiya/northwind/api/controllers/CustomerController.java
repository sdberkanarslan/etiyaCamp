package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customer.CreateCustomerRequest;
import com.etiya.northwind.business.responses.customer.CustomerListResponse;
import com.etiya.northwind.business.requests.customer.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/getall")
	public List<CustomerListResponse> getAll() {
		return this.customerService.getAlL();

	}

	@GetMapping("/{customerId}")
	public CustomerListResponse getCustomerById(@PathVariable String customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@PostMapping
	public CustomerListResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest)
	{
		return customerService.createCustomer(createCustomerRequest);
	}

	@DeleteMapping("/{customerId}")
	public void deleteCustomerById(@PathVariable String customerId){
		customerService.deleteCustomerById(customerId);
	}


	@PutMapping("/{customerId}")
	public CustomerListResponse updateCustomer(@PathVariable String customerId, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
		return customerService.updateCustomer(customerId, updateCustomerRequest);
	}

	@GetMapping("/getAllWithPaging")
	public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
		return this.customerService.findByPageable(page-1,size);

	}

	@GetMapping("/getallpagesorderbyproperty")
	public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

		return this.customerService.getAllPagesOrderByEntity(pageNumber,pageSize, property,type.orElse(""));

	}
}
