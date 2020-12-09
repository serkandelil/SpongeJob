package com.spongejob.spongejob.repository;

import com.spongejob.spongejob.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    Optional<Employee> findByEmployeeId(Long employeeId);

    void deleteByEmployeeId(Long employeeId);

    Optional<Employee> findByUsernameAndPassword(String username, String password);
}