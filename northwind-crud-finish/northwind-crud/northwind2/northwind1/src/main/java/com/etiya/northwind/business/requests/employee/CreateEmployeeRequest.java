package com.etiya.northwind.business.requests.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {

    private Integer employeeId;
    private String firstName;
    private String lastName;
}
