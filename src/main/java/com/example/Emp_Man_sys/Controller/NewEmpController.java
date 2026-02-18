package com.example.Emp_Man_sys.Controller;


import com.example.api.EmployeesApi;
import com.example.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewEmpController implements EmployeesApi {

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {

        Employee emp = new Employee();
        emp.setId(1L);
        emp.setName("Sarthak");
        emp.setEmail("sarthak@test.com");
        emp.setDepartmentId(101L);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp);

        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Employee employee) {

        // Normally you would save to DB
        employee.setId(100L);

        return ResponseEntity.status(201).body(employee);
    }
}
