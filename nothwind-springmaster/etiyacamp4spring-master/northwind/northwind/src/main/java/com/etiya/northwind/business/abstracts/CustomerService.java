package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.products.ProductListResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerListResponse> getAlL();
}
