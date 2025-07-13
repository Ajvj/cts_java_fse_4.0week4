package com.zoho.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")
public class EmployeeDirectoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDirectoryServiceApplication.class, args);
    }
}
