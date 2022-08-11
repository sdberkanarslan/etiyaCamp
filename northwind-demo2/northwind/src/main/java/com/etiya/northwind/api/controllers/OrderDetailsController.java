package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.GetOrderDetailByIdResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {

    private OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailsController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @GetMapping("/getall")
    DataResult<List<OrderDetailListResponse>> getAll() {
        return this.orderDetailService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<GetOrderDetailByIdResponse> getById(int orderId, int productId){
        return this.orderDetailService.getById(orderId,productId);
    }
    @PostMapping("/add")
    public Result add(CreateOrderDetailRequest createOrderDetailRequest){
        return  this.orderDetailService.add(createOrderDetailRequest);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest){
        return  this.orderDetailService.delete(deleteOrderDetailRequest);
    }
    @PutMapping("/update")
    public Result update(@RequestBody UpdateOrderDetailRequest updateOrderDetailRequest){
        return  this.orderDetailService.update(updateOrderDetailRequest);
    }
}