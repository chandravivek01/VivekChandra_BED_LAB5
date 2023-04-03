package com.vcs.employee.service;

import java.util.List;

import com.vcs.employee.entity.Employee;

public interface EmployeeService {

	public Employee viewEmployeeById(int id);

	public List<Employee> viewAllEmployees();

	public void associateEmployee(Employee employee);

	public void removeEmployeeById(int id);

}
