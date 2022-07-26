package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.OrderListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
