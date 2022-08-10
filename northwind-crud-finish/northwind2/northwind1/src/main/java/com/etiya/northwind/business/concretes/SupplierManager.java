package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.ProductListResponse;
import com.etiya.northwind.business.responses.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {


    private final SupplierRepository supplierRepository;
    private final ModelMapperService modelMapperService;

    public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
        this.supplierRepository = supplierRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<SupplierListResponse> getAlL() {
        List<Supplier> result = this.supplierRepository.findAll();
        List<SupplierListResponse> response = result
                .stream()
                .map(supplier -> this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class))
                .collect(Collectors.toList());
        return response;
    }
}