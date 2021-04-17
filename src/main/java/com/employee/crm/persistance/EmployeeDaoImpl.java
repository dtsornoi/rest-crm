package com.employee.crm.persistance;

import com.employee.crm.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> listAll() {
        return entityManager
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee saveOrUpdateEmployee(Employee employee) {

       return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager
                .createQuery("delete from Employee where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
