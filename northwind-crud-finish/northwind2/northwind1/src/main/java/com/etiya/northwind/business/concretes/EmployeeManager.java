package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.EmployeeListResponse;
import com.etiya.northwind.business.responses.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;

    public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
        this.employeeRepository = employeeRepository;
        this.modelMapperService = modelMapperService;
    }


    @Override
    public List<EmployeeListResponse> getAlL() {
        List<Employee> result = this.employeeRepository.findAll();
        List<EmployeeListResponse> response = result
                .stream()
                .map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class))
                .collect(Collectors.toList());
        return response;
    }
}
