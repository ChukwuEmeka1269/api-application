package com.rexcoinc.apiapplication.repository;

import com.rexcoinc.apiapplication.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.addAll(
                List.of(
                        new Employee(1L, "John", "Doe", "johndoe@gmail.com"),
                        new Employee(2L, "Jane", "Doe", "janedoe@gmail.com"),
                        new Employee(3L, "Mike", "Ross", "mikeross@gmail.com")
                )
        );
    }

    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(DATABASE);
    }

    public Employee getEmployeeById(Long id) {
        return DATABASE.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public void updateEmployee(Employee employee) {
        var updatedEmployee = mapToEmployee(employee);
        var indexOfEmployeeFromDB = DATABASE.indexOf(updatedEmployee);
        DATABASE.set(indexOfEmployeeFromDB, updatedEmployee);
    }

    public Boolean deleteEmployee(Long id) {
        var employeeFromDB = getEmployeeById(id);
        return DATABASE.remove(employeeFromDB);
    }


    private Employee mapToEmployee(Employee employeeDto) {
        var employeeFromDB = getEmployeeById(employeeDto.getId());

        employeeFromDB.setLastName(employeeDto.getLastName());
        employeeFromDB.setFirstName(employeeDto.getFirstName());
        employeeFromDB.setUsername(employeeDto.getUsername());
        employeeFromDB.setId(employeeDto.getId());

        return employeeFromDB;
    }
}
