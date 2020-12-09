package com.spongejob.spongejob.mapper;

import com.spongejob.spongejob.dto.EmployeeDTO;
import com.spongejob.spongejob.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public EmployeeDTO maptoDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setCv(employee.getCv());


        return employeeDTO;
    }

    public List<EmployeeDTO> maptoDto(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<>();
        for ( Employee employee : employees ) {
            list.add( maptoDto( employee ) );
        }

        return list;
    }

    public Employee maptoEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFirstname(employeeDTO.getFirstname());
        employee.setSurname(employeeDTO.getSurname());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAge(employeeDTO.getAge());
        employee.setCv(employeeDTO.getCv());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());

        return employee;
    }

    public List<Employee> maptoEntity(List<EmployeeDTO> employeeDTOS) {
        if ( employeeDTOS == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<>();
        for ( EmployeeDTO employeeDTO : employeeDTOS ) {
            list.add( maptoEntity( employeeDTO ) );
        }

        return list;
    }
}