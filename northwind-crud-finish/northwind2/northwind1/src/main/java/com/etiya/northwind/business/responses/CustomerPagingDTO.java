package com.etiya.northwind.business.responses;

import com.etiya.northwind.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPagingDTO {

    private List<String> customers;
    private int totalPages;

}
