package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.GetCartsByIdResponce;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.CartProductDetailRepository;
import com.etiya.northwind.dataAccess.abstracts.CartRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.CartProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartManager implements CartService {


    private CartRepository cartRepository;

    private ModelMapperService modelMapperService;

    @Autowired
    public CartManager(CartRepository cartRepository, ModelMapperService modelMapperService) {
        this.cartRepository = cartRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public Result add(CreateCartRequest createCartRequest) {
        Cart cart = this.modelMapperService.forRequest().map(createCartRequest,Cart.class);
         this.cartRepository.save(cart);
         return new SuccessResult("CART ADDED");

    }

    @Override
    public Result delete(DeleteCartRequest deleteCartRequest) {
        Cart cart = this.modelMapperService.forRequest().map(deleteCartRequest,Cart.class);
        this.cartRepository.delete(cart);
        return new SuccessResult("CART DELETED");

    }

    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        Cart cart = this.modelMapperService.forRequest().map(updateCartRequest,Cart.class);
        this.cartRepository.save(cart);
        return new SuccessResult("CART UPDATED");
    }

}
