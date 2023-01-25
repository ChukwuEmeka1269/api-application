package com.rexcoinc.apiapplication.repository;

import com.rexcoinc.apiapplication.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

}
