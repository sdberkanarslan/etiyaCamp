package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.CreateCustomerRequest;
import com.etiya.northwind.business.responses.CustomerListResponse;

import com.etiya.northwind.business.responses.UpdateCustomerRequest;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {


    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;


    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<CustomerListResponse> getAlL() {
        List<Customer> result = this.customerRepository.findAll();
        List<CustomerListResponse> response = result
                .stream()
                .map(customer -> this.modelMapperService.forResponse().map(customer, CustomerListResponse.class))
                .collect(Collectors.toList());
        return response;
    }


    @Override
    public CustomerListResponse getCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return null;
        }
        return this.modelMapperService.forResponse().map(customer, CustomerListResponse.class);

    }


    @Override
    public CustomerListResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);

        customerRepository.save(customer);

        return this.modelMapperService.forResponse().map(customer, CustomerListResponse.class);
    }

    @Override
    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerListResponse updateCustomer(String customerId, UpdateCustomerRequest updateCustomerRequest) {

        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            return null;
        }
        Customer customer2 = this.modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        customer2.setCustomerId(customer.getCustomerId());

        customerRepository.save(customer2);
        return this.modelMapperService.forResponse().map(customer2, CustomerListResponse.class);

    }


}
