package com.rexcoinc.apiapplication.util;

import com.rexcoinc.apiapplication.domain.Employee;

public class ServiceUtil {

    public static Employee mapToEmployee(Employee employeeDto, Employee employeeFromDB) {
//        var employeeFromDB = getEmployeeById(employeeDto.getId());

        employeeFromDB.setLastName(employeeDto.getLastName());
        employeeFromDB.setFirstName(employeeDto.getFirstName());
        employeeFromDB.setUsername(employeeDto.getUsername());
        employeeFromDB.setId(employeeDto.getId());

        return employeeFromDB;
    }
}
