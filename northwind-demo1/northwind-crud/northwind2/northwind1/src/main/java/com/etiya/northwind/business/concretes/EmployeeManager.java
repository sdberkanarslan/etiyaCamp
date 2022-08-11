package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employee.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employee.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employee.EmployeeListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.sort.SortingEntities;
import com.etiya.northwind.dataAccess.abstracts.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public EmployeeListResponse getEmployeeById(String employeeId) {
        Employee employee = employeeRepository.findById(Integer.valueOf(employeeId)).orElse(null);

        if (employee == null) {
            return null;
        }
        return this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class);

    }


    @Override
    public EmployeeListResponse createEmployee(CreateEmployeeRequest createEmployeeRequest) {

        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);

        employeeRepository.save(employee);

        return this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteById(Integer.valueOf(employeeId));
    }

    @Override
    public EmployeeListResponse updateEmployee(String employeeId, UpdateEmployeeRequest updateEmployeeRequest) {

        Employee employee = employeeRepository.findById(Integer.valueOf(employeeId)).orElse(null);
        if (employee == null) {
            return null;
        }
        Employee employee2 = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        employee2.setEmployeeId(employee.getEmployeeId());

        employeeRepository.save(employee2);
        return this.modelMapperService.forResponse().map(employee2, EmployeeListResponse.class);

    }


    @Override
    public Map<String, Object> findByPageable(int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Employee> result = employeeRepository.findAll(pageable);
        List<Employee> employees = result.getContent();
        List<EmployeeListResponse> employeeListResponses = employees.stream().map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeListResponse.class))
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("Employees",employeeListResponses);
        response.put("CurrentPage",result.getNumber()+1);
        response.put("Total Items",result.getTotalElements());
        response.put("Total Pages",result.getTotalPages());

        return response;
    }

    @Override
    public Map<String, Object> getAllPagesOrderByEntity(int pageNumber, int pageSize,String property,String type) {
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize, SortingEntities.sortType(property,type));



        Page<Employee>result =employeeRepository.findAll(pageable);
        Map<String,Object> response=new HashMap<>();
        response.put("totalElements",result.getTotalElements()) ;
        response.put("totalPages",result.getTotalPages());
        response.put("currentPage",result.getNumber()+1);
        response.put("result",result.getContent().stream().map(employee ->
                this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList()));

        return response ;
    }
}

