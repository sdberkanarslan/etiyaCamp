package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.order.CreateOrderDetailRequest;
import com.etiya.northwind.business.responses.order.OrderDetailListResponse;
import com.etiya.northwind.business.requests.order.UpdateOrderDetailRequest;
import com.etiya.northwind.entities.concretes.OrderDetailsId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderdetails")

public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/getall")
    public List<OrderDetailListResponse> getAll() {
        return this.orderDetailService.getAlL();
    }

    @GetMapping("/geyById/")
    public OrderDetailListResponse getOrderDetailById(@RequestParam Integer orderId, @RequestParam Integer productId) {
        return orderDetailService.getOrderDetailById(orderId,productId);
    }

    @PostMapping
    public OrderDetailListResponse createOrderDetail(@RequestBody CreateOrderDetailRequest createOrderDetailRequest)
    {
        return orderDetailService.createOrderDetail(createOrderDetailRequest);
    }

    @DeleteMapping
    public void deleteOrderDetailById(@RequestParam Integer orderId, @RequestParam Integer productId){
        orderDetailService.deleteOrderDetailById(orderId,productId);
    }

    @PutMapping
    public OrderDetailListResponse updateOrderDetail(@RequestBody OrderDetailsId orderDetailsId, @RequestBody UpdateOrderDetailRequest updateOrderDetailRequest) {
        return orderDetailService.updateOrderDetail(orderDetailsId, updateOrderDetailRequest);
    }

    @GetMapping("/getAllWithPaging")
    public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return this.orderDetailService.findByPageable(page-1,size);

    }

    @GetMapping("/getallpagesorderbyproperty")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

        return this.orderDetailService.getAllPagesOrderByEntity(pageNumber,pageSize, property,type.orElse(""));

    }
}
