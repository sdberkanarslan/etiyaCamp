package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.CreateCustomerRequest;
import com.etiya.northwind.business.responses.CustomerListResponse;
import com.etiya.northwind.business.responses.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerListResponse> getAlL();

	CustomerListResponse getCustomerById(String customerId);

	CustomerListResponse createCustomer(CreateCustomerRequest createCustomerRequest);

	void deleteCustomerById(String customerId);

	CustomerListResponse updateCustomer(String customerId, UpdateCustomerRequest updateCustomerRequest);
}
