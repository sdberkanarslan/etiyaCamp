package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.core.results.Result;

public interface CartService {

    Result add(CreateCartRequest createCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    Result update(UpdateCartRequest updateCartRequest);




}
