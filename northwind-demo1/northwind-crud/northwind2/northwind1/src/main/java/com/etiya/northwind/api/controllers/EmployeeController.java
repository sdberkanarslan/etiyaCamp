package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employee.CreateEmployeeRequest;
import com.etiya.northwind.business.responses.employee.EmployeeListResponse;
import com.etiya.northwind.business.requests.employee.UpdateEmployeeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public List<EmployeeListResponse> getAll() {
        return this.employeeService.getAlL();
    }

    @GetMapping("/{employeeId}")
    public EmployeeListResponse getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeListResponse createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest)
    {
        return employeeService.createEmployee(createEmployeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable String employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public EmployeeListResponse updateEmployee(@PathVariable String employeeId, @RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.updateEmployee(employeeId, updateEmployeeRequest);
    }

    @GetMapping("/getAllWithPaging")
    public Map<String, Object> getAllWithPaging(@RequestParam int page, @RequestParam int size) {
        return this.employeeService.findByPageable(page-1,size);

    }
    @GetMapping("/getallpagesorderbyproperty")
    public Map<String,Object> getAllPagesOrderByEntity(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String property,@RequestParam Optional<String> type){

        return this.employeeService.getAllPagesOrderByEntity(pageNumber,pageSize, property,type.orElse(""));

    }
}
