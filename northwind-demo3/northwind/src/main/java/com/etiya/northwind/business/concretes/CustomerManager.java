package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.GetCustomerByIdResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CustomerRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository,ModelMapperService modelMapperService) {

        this.modelMapperService=modelMapperService;
        this.customerRepository = customerRepository;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {

        Customer customer=this.modelMapperService.forResponse().map(createCustomerRequest, Customer.class);
        customerRepository.save(customer);
        return new SuccessResult ("CUSTOMER ADDED");


    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {

        Customer customer=this.modelMapperService.forResponse().map(updateCustomerRequest,Customer.class);
        this.customerRepository.save(customer);

        return new SuccessResult ("CUSTOMER UPDATED");

    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        this.customerRepository.deleteById(deleteCustomerRequest.getCustomerId());

        return new SuccessResult ("CUSTOMER DELETED");

    }

    @Override
    public DataResult<GetCustomerByIdResponse> getById(String id) {
        Customer customer=this.customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));

       return new SuccessDataResult<GetCustomerByIdResponse>(this.modelMapperService.forResponse().map(customer,GetCustomerByIdResponse.class));
    }


    @Override
    public DataResult<List<CustomerListResponse>> getAll() {
        List<Customer> result = this.customerRepository.findAll();
        List<CustomerListResponse> responses = result.stream().map(customer -> this.modelMapperService.forResponse().
                map(customer, CustomerListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<CustomerListResponse>>(responses);

    }
    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        return pageableMap(pageable);
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));
        return   pageableMap(pageable);

    }

    private Map<String, Object> pageableMap(Pageable pageable){
        Map<String,Object> response=new HashMap<>();
        Page<Customer> customers =customerRepository.findAll(pageable);
        response.put("totalElements",customers.getTotalElements()) ;
        response.put("totalPages",customers.getTotalPages());
        response.put("currentPage",customers.getNumber()+1);
        response.put("customers",customers.getContent().stream().map(customer ->
                this.modelMapperService.forResponse().map(customer, Sort.Order.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
}
