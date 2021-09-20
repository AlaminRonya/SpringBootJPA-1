package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.moduls.Employee;
import com.example.demo.services.EmployeeServices;


@RestController
public class ControllerClass {
	
	private final EmployeeServices EMPLOYEE_SERVICES;
	
	
	@Autowired
	public ControllerClass(EmployeeServices employeeServices) {
		this.EMPLOYEE_SERVICES = employeeServices;
		
	}
	
	@GetMapping(value = "/addEmployee")
	public void addEmployee() {
		Employee employee = new Employee("Md. ", "Al Amin", "webclubrony@gmail.com",LocalDate.of(2000, Month.JANUARY, 15));
		EMPLOYEE_SERVICES.save(employee);
	}
	@GetMapping(value = "/all" )
	public List<Employee> getEmployees(){
		return EMPLOYEE_SERVICES.allEmployee();
	}
	@GetMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		EMPLOYEE_SERVICES.deleteEmployee(id);
		
	}
	

}
