package com.etiya.northwind.business.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListResponse {
    private int orderId;
    private LocalDate orderDate;
    private String employeeFirstName ;
    private String employeeLastName ;
    private String customerCompanyName ;
    private String customerContactName ;
}
