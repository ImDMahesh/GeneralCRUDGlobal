package com.cam.generalcrud.service;

import com.cam.generalcrud.bean.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);

    public List<Employee> fetchAllEmployees();

    public Employee getEmployeeByID(Long employeeID);

    public void deleteEmployeeByID(Long employeeID);

    public Employee updateEmployee(Employee employee);
}
