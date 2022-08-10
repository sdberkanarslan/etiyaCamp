package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.SupplierListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")

public class SuppliersController {
    private final SupplierService supplierService;

    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/getall")
    public List<SupplierListResponse> getAll() {
        return this.supplierService.getAlL();
    }
}
