package com.vcs.employee.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcs.employee.dao.EmployeeRepository;
import com.vcs.employee.entity.Employee;
import com.vcs.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee viewEmployeeById(int id) {
		Employee employee = employeeRepository.findById(id).get();

		if (employee == null)
			throw new RuntimeException("Did not find the employee id: " + id);
		else
			return employee;

	}

	@Override
	public List<Employee> viewAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void associateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void removeEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

}
