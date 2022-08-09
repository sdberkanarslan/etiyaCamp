package com.etiya.northwind.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResponse {

    private int orderId;
    private String customerCustomerId;
    private String customerName;
    private int employeeId;
    private String employeeName;


}
