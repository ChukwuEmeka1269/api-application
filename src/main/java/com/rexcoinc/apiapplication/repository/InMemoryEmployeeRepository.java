package com.rexcoinc.apiapplication.repository;

import com.rexcoinc.apiapplication.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static{
        DATABASE.addAll(
                List.of(
                        new Employee(1L, "John", "Doe", "johndoe@gmail.com"),
                        new Employee(2L, "Jane", "Doe", "janedoe@gmail.com"),
                        new Employee(2L, "Mike", "Ross", "mikeross@gmail.com")
                )
        );
    }

    public void addEmployee(Employee employee){
        DATABASE.add(employee);
    }

    List<Employee> getAllEmployees(){
        return List.copyOf(DATABASE);
    }

    public Employee getEmployeeById(Long id){
        return DATABASE.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    void updateEmployee(Employee employee){
        var employeeFromDB = getEmployeeById(employee.getId());
        var updatedEmployee = mapToEmployee(employeeFromDB);
        DATABASE.add(updatedEmployee);
    }

    Boolean deleteEmployee(Long id){
        var employeeFromDB = getEmployeeById(id);
        return DATABASE.remove(employeeFromDB);
    }


    private Employee mapToEmployee(Employee employeeDto){
        var mappedEmployee = new Employee();
        mappedEmployee.setFirstName(employeeDto.getFirstName());
        mappedEmployee.setLastName(employeeDto.getLastName());
        mappedEmployee.setUsername(employeeDto.getUsername());
        mappedEmployee.setId(employeeDto.getId());

        return mappedEmployee;
    }
}
