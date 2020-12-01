package com.spongejob.spongejob.service;

import com.spongejob.spongejob.model.Employee;
import com.spongejob.spongejob.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByEmployeeId(Long employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).orElseThrow(EntityNotFoundException::new);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteByEmployeeId(employeeId);
    }
}