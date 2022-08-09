package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.OrderDetailListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
