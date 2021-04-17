package com.employee.crm.rest;

import com.employee.crm.entity.Employee;
import com.employee.crm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>>  listAllEmployees(){
        List<Employee> response = employeeService.listAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.findEmployeeById(id);

        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee response = employeeService.saveOrUpdateEmployee(employee);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<HttpStatus> updateEmployee(@RequestBody Employee employee){
       Employee checkIfExists = employeeService.findEmployeeById(employee.getId());

       if (checkIfExists == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       
        employeeService.saveOrUpdateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.findEmployeeById(id);

        if (employee == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
