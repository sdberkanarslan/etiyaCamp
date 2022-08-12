package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.GetEmployeeByIdResponse;
import com.etiya.northwind.business.responses.suppliers.GetSupplierByIdResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.results.DataResult;
import com.etiya.northwind.core.results.Result;
import com.etiya.northwind.core.results.SuccessDataResult;
import com.etiya.northwind.core.results.SuccessResult;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.SupplierRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Employee;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public SupplierManager(SupplierRepository supplierRepository,ModelMapperService modelMapperService) {
        this.supplierRepository = supplierRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public Result add(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier=this.modelMapperService.forRequest().map(createSupplierRequest,Supplier.class);
        supplierRepository.save(supplier);

        return new SuccessResult("SUPPLIER ADDED");

    }

    @Override
    public Result update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier=this.modelMapperService.forRequest().map(updateSupplierRequest,Supplier.class);
        supplierRepository.save(supplier);

        return new SuccessResult("SUPPLIER UPDATED");


    }

    @Override
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {

        this.supplierRepository.deleteById(deleteSupplierRequest.getSupplierId());

        return new SuccessResult("SUPPLIER DELETED");

    }

    @Override
    public DataResult<GetSupplierByIdResponse> getById(int id) {
        Supplier supplier=this.supplierRepository.findById(id);
        GetSupplierByIdResponse getSupplierByIdResponse=this.modelMapperService.forResponse().map(supplier,GetSupplierByIdResponse.class);
        return new SuccessDataResult<GetSupplierByIdResponse>(getSupplierByIdResponse);
    }

    @Override
    public DataResult<List<SupplierListResponse>> getAll() {
        List<Supplier> result = this.supplierRepository.findAll();
        List<SupplierListResponse> responses = result.stream().map(supplier -> this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<SupplierListResponse>>(responses);
    }

    @Override
    public Map<String, Object> getAllPages(int pageNumber, int pageSize) {
        Pageable pageable= PageRequest.of(pageNumber-1,pageSize);
        Map<String,Object> response=new HashMap<>();

        Page<Supplier> suppliers =supplierRepository.findAll(pageable);
        response.put("totalElements",suppliers.getTotalElements()) ;
        response.put("totalPages",suppliers.getTotalPages());
        response.put("currentPage",suppliers.getNumber()+1);
        response.put("suppliers",suppliers.getContent().stream().map(supplier ->
                this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class)).collect(Collectors.toList()));

        return response ;
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize, String entity, String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize,sortType(entity,type));
        Map<String,Object> response=new HashMap<>();
        Page<Supplier>suppliers =supplierRepository.findAll(pageable);
        response.put("totalElements",suppliers.getTotalElements()) ;
        response.put("totalPages",suppliers.getTotalPages());
        response.put("currentPage",suppliers.getNumber()+1);
        response.put("suppliers",suppliers.getContent().stream().map(supplier ->
                this.modelMapperService.forResponse().map(supplier, SupplierListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
    public Sort sortType(String property, String type){
        if(type.equals("desc"))
            return Sort.by(property).descending();
        else return Sort.by(property).ascending() ;

    }
}