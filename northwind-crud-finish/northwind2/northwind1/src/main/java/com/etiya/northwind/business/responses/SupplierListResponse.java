package com.etiya.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierListResponse {

    private Integer supplierId;
    private String companyName;
    private String contactName;
}
