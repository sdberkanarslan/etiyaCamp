package com.etiya.northwind.business.requests.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private int orderId;
    private String customerId;
    private int employeeId;
    private LocalDate orderDate;
}
