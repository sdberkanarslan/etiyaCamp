package com.etiya.northwind.business.requests.order;

import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private Integer orderId;
    private String customerId;
    private String employeeId;

}
