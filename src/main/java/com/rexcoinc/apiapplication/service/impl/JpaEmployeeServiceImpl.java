package com.rexcoinc.apiapplication.service.impl;

import com.rexcoinc.apiapplication.domain.Employee;
import com.rexcoinc.apiapplication.repository.EmployeeJpaRepository;
import com.rexcoinc.apiapplication.service.EmployeeService;
import com.rexcoinc.apiapplication.util.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Qualifier(value = "mySQLEmployeeService")
@RequiredArgsConstructor
@Service
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final EmployeeJpaRepository employeeJpaRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeJpaRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeJpaRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeJpaRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Employee employee) {
        var employeeInDb = getEmployeeById(employee.getId());
        if(Objects.nonNull(employeeInDb)){
            var employeeToSave = ServiceUtil.mapToEmployee(employee, employeeInDb);
            employeeJpaRepository.save(employeeToSave);
        }
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        employeeJpaRepository.deleteById(id);
        return true;
    }
}
