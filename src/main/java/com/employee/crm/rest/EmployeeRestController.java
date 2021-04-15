package com.employee.crm.rest;

import com.employee.crm.entity.Employee;
import com.employee.crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

//    @GetMapping("/login")
//    public Principal user(Principal user) {
//        return user;
//    }

    @GetMapping("/employees")
    public List<Employee> listAllEmployees(){
        return employeeService.listAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.findEmployeeById(id);

        if (employee == null){
            throw new RuntimeException("No such employee");
        }

        return employee;
    }

    @PostMapping("/employees")
    public void saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.saveOrUpdateEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.findEmployeeById(id);

        if (employee == null){
            throw new RuntimeException("Employee not found");
        }

        employeeService.deleteEmployee(id);
    }


}
