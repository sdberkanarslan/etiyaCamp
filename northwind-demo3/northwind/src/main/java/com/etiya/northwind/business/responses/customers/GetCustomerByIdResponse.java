package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerByIdResponse {
    private String customerId;
    private String companyName;
    private String contactName;
}
