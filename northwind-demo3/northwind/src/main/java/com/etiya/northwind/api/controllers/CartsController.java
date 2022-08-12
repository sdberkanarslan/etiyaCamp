package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/carts")
public class CartsController {

    @Autowired
    private CartService cartService;
    public CartsController (CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCartRequest createCartRequest) {
        return this.cartService.add(createCartRequest);

    }

    @PutMapping ("/update")
    public Result update(@RequestBody UpdateCartRequest updateCartRequest) {
        return this.cartService.update(updateCartRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteCartRequest deleteCartRequest) {
        return this.cartService.delete(deleteCartRequest);
    }


}
