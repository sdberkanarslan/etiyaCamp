package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.CreateCustomerRequest;
import com.etiya.northwind.business.responses.CustomerListResponse;

import com.etiya.northwind.business.responses.CustomerPagingDTO;
import com.etiya.northwind.business.responses.UpdateCustomerRequest;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


    @Override
    public Map<String, Object> findByPageable(int page, int size) {





        Pageable pageable = PageRequest.of(page,size);
        Pageable sortedByName = PageRequest.of(page,size, Sort.by("companyName").descending());
        Page<Customer> result = customerRepository.findAll(pageable);
        List<Customer> customers = result.getContent();
        List<CustomerListResponse> customerListResponses = customers.stream().map(customer -> this.modelMapperService.forResponse().map(customer, CustomerListResponse.class))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("Customers",customerListResponses);
        response.put("CurrentPage",result.getNumber());
        response.put("Total Items",result.getTotalElements());
        response.put("Total Pages",result.getTotalPages());

        return response;
    }

}
