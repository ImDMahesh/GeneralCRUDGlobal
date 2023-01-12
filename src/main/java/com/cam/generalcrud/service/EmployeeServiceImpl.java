package com.cam.generalcrud.service;

import com.cam.generalcrud.bean.Employee;
import com.cam.generalcrud.exception.EmptyInputException;
import com.cam.generalcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {

        if (employee.getName().isEmpty() || employee.getName().length() == 0) {
            throw new EmptyInputException("6001", "Employee Name should not be blank");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        List<Employee> employeeList = null;
        employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeByID(Long employeeID) {
      /*  Optional<Employee> employee = employeeRepo.findById(employeeID);
        if (employee.isPresent())
            return employee.get();*/
        return employeeRepository.findById(employeeID).get();
    }

    @Override
    public void deleteEmployeeByID(Long employeeID) {
        Employee employee = getEmployeeByID(employeeID);
        if (Objects.nonNull(employee))
            employeeRepository.deleteById(employeeID);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }
}
