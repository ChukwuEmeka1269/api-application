package com.rexcoinc.apiapplication.service.impl;

import com.rexcoinc.apiapplication.domain.Employee;
import com.rexcoinc.apiapplication.repository.InMemoryEmployeeRepository;
import com.rexcoinc.apiapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier(value = "InMemoryService")
@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return inMemoryEmployeeRepository.getEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        return inMemoryEmployeeRepository.deleteEmployee(id);
    }
}
