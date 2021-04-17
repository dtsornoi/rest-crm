package com.employee.crm.persistance;

import com.employee.crm.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> listAll();
    Employee findEmployeeById(int id);
    Employee saveOrUpdateEmployee(Employee employee);
    void deleteEmployee(int id);
}
