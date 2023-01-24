package com.rexcoinc.apiapplication.service;

import com.rexcoinc.apiapplication.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    void updateEmployee(Employee employee);

    Boolean deleteEmployee(Long id);

}