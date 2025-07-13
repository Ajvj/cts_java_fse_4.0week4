package com.zoho.directory.dao;

import com.zoho.directory.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Repository
public class DepartmentDao {

    private List<Department> DEPARTMENT_LIST;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
