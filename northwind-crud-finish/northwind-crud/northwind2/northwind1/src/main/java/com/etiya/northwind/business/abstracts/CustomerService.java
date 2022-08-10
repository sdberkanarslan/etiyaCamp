package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.customer.CreateCustomerRequest;
import com.etiya.northwind.business.responses.customer.CustomerListResponse;
import com.etiya.northwind.business.requests.customer.UpdateCustomerRequest;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<CustomerListResponse> getAlL();

	CustomerListResponse getCustomerById(String customerId);

	CustomerListResponse createCustomer(CreateCustomerRequest createCustomerRequest);

	void deleteCustomerById(String customerId);

	CustomerListResponse updateCustomer(String customerId, UpdateCustomerRequest updateCustomerRequest);

	Map<String, Object> findByPageable(int page, int size);

    Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String property, String orElse);
}




