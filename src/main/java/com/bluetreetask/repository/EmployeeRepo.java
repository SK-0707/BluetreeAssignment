package com.bluetreetask.repository;

import com.bluetreetask.model.Employee;

import java.util.List;

public interface EmployeeRepo {
   public List<Employee> getAllEmployees();
   public Employee getEmployeeById(int empId);
   public Employee addEmployee(Employee emp);
   public Employee updateEmployee(Employee emp);
   public boolean deleteEmployee(int empId);
}
