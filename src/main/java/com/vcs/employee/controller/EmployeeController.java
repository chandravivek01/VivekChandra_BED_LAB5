package com.vcs.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcs.employee.entity.Employee;
import com.vcs.employee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/new")
	public String createEmployee(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}

	@GetMapping("")
	public String listEmployees(Model theModel) {

		List<Employee> employees = employeeService.viewAllEmployees();
		theModel.addAttribute("employees", employees);
		return "employees/list-employees";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.associateEmployee(employee);
		return "redirect:/employees";
	}

	@PostMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {

		employeeService.removeEmployeeById(id);
		return "redirect:/employees";
	}

	@PostMapping("/edit/{id}")
	public String updateEmployee(@PathVariable("id") int id, Model model) {

		Employee employee = employeeService.viewEmployeeById(id);
		model.addAttribute("employee", employee);
		return "employees/update-employee";
	}

}
