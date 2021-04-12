package com.employee.crm.service;

import com.employee.crm.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();
    Employee findEmployeeById(int id);
    void saveOrUpdateEmployee(Employee employee);
    void deleteEmployee(int id);
}
