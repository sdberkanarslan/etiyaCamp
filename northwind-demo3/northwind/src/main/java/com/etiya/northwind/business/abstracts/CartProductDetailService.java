package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.cartProductDetails.CreateCartsProductDetailRequest;
import com.etiya.northwind.business.requests.cartProductDetails.DeleteCartsProductDetailRequest;
import com.etiya.northwind.business.requests.cartProductDetails.UpdateCartsProductDetailRequest;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.GetCartsByIdResponce;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;

public interface CartProductDetailService {


    Result add(CreateCartsProductDetailRequest createCartsProductDetailRequest);
    Result delete(DeleteCartsProductDetailRequest deleteCartsProductDetailRequest);
    Result update(UpdateCartsProductDetailRequest updateCartsProductDetailRequest);
    DataResult <GetCartsByIdResponce> getById(int cartId, int productId);
}
