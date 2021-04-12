package com.employee.crm.service;

import com.employee.crm.entity.Employee;
import com.employee.crm.persistance.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> listAll() {
        return employeeDAO.listAll();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
