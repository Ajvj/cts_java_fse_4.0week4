package com.zoho.directory.dao;

import com.zoho.directory.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Repository
public class EmployeeDao {

    private List<Employee> EMPLOYEE_LIST;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}

