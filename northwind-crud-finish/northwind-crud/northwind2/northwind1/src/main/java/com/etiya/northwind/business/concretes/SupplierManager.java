package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.supplier.CreateSupplierRequest;
import com.etiya.northwind.business.responses.supplier.SupplierListResponse;
import com.etiya.northwind.business.requests.supplier.UpdateSupplierRequest;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.sort.SortingEntities;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Override
    public SupplierListResponse getSupplierById(String supplierId) {
        Supplier supplier = supplierRepository.findById(Integer.valueOf(supplierId)).orElse(null);

        if (supplier == null) {
            return null;
        }
        return this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class);

    }


    @Override
    public SupplierListResponse createSupplier(CreateSupplierRequest createSupplierRequest) {

        Supplier supplier = this.modelMapperService.forRequest().map(createSupplierRequest, Supplier.class);

        supplierRepository.save(supplier);

        return this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class);
    }

    @Override
    public void deleteSupplierById(String supplierId) {
        supplierRepository.deleteById(Integer.valueOf(supplierId));
    }

    @Override
    public SupplierListResponse updateSupplier(String supplierId, UpdateSupplierRequest updateSupplierRequest) {

        Supplier supplier = supplierRepository.findById(Integer.valueOf(supplierId)).orElse(null);
        if (supplier == null) {
            return null;
        }
        Supplier supplier2 = this.modelMapperService.forRequest().map(updateSupplierRequest, Supplier.class);
        supplier2.setSupplierId(supplier.getSupplierId());

        supplierRepository.save(supplier2);
        return this.modelMapperService.forResponse().map(supplier2, SupplierListResponse.class);

    }


    @Override
    public Map<String, Object> findByPageable(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Supplier> result = supplierRepository.findAll(pageable);
        List<Supplier> suppliers = result.getContent();
        List<SupplierListResponse> supplierListResponses =
                suppliers
                        .stream()
                        .map(supplier ->
                                this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class))
                        .collect(Collectors.toList());


        Map<String, Object> response = new HashMap<>();
        response.put("Suppliers",supplierListResponses);
        response.put("CurrentPage",result.getNumber()+1);
        response.put("Total Items",result.getTotalElements());
        response.put("Total Pages",result.getTotalPages());

        return response;
    }

    @Override
    public Map<String, Object> getAllPagesSupplierByEntity(int pageNumber, int pageSize,String property,String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize, SortingEntities.sortType(property,type));



        Page<Supplier>result =supplierRepository.findAll(pageable);
        Map<String,Object> response=new HashMap<>();
        response.put("totalElements",result.getTotalElements()) ;
        response.put("totalPages",result.getTotalPages());
        response.put("currentPage",result.getNumber()+1);
        response.put("result",result.getContent().stream().map(supplier ->
                this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
}