package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.order.CreateCombineOfOrderRequestAndOrderDetailRequest;
import com.etiya.northwind.business.requests.order.UpdateOrderRequest;
import com.etiya.northwind.business.responses.order.OrderListResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")

public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getall")
    public List<OrderListResponse> getAll() {
        return this.orderService.getAlL();
    }

    @GetMapping("/{orderId}")
    public OrderListResponse getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public OrderListResponse createOrder(@RequestBody CreateCombineOfOrderRequestAndOrderDetailRequest createCombineOfOrderRequestAndOrderDetailRequest)
    {
        return orderService.createOrder(createCombineOfOrderRequestAndOrderDetailRequest);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable String orderId){
        orderService.deleteOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public OrderListResponse updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderRequest updateOrderRequest) {
        return orderService.updateOrder(orderId, updateOrderRequest);
    }

    @GetMapping("/getAllWithPaging")
    public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return this.orderService.findByPageable(page-1,size);

    }
    @GetMapping("/getallpagesorderbyproperty")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

        return this.orderService.getAllPagesOrderByEntity(pageNumber,pageSize, property,type.orElse(""));

    }
}
