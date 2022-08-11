package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.supplier.CreateSupplierRequest;
import com.etiya.northwind.business.responses.supplier.SupplierListResponse;
import com.etiya.northwind.business.requests.supplier.UpdateSupplierRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/{supplierId}")
    public SupplierListResponse getSupplierById(@PathVariable String supplierId) {
        return supplierService.getSupplierById(supplierId);
    }

    @PostMapping
    public SupplierListResponse createSupplier(@RequestBody CreateSupplierRequest createSupplierRequest)
    {
        return supplierService.createSupplier(createSupplierRequest);
    }

    @DeleteMapping("/{supplierId}")
    public void deleteSupplierById(@PathVariable String supplierId){
        supplierService.deleteSupplierById(supplierId);
    }

    @PutMapping("/{supplierId}")
    public SupplierListResponse updateSupplier(@PathVariable String supplierId, @RequestBody UpdateSupplierRequest updateSupplierRequest) {
        return supplierService.updateSupplier(supplierId, updateSupplierRequest);
    }

    @GetMapping("/getAllWithPaging")
    public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return this.supplierService.findByPageable(page-1,size);

    }
    @GetMapping("/getallpagessupplierbyproperty")
    public Map<String,Object> getAllPagesSupplierByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

        return this.supplierService.getAllPagesSupplierByEntity(pageNumber,pageSize, property,type.orElse(""));

    }
}
