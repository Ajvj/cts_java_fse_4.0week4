package com.zoho.directory.controller;

import com.zoho.directory.model.Department;
import com.zoho.directory.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }
}
