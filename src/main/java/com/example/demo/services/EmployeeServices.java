package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.moduls.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServices {
	private final EmployeeRepository EMPLOYEE_REPOSITORY;
	
	@Autowired
	public EmployeeServices(EmployeeRepository eMPLOYEE_REPOSITORY) {
		EMPLOYEE_REPOSITORY = eMPLOYEE_REPOSITORY;
	}


	public List<Employee> allEmployee() {
		return EMPLOYEE_REPOSITORY.findAll();
	}


	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		Optional<Employee> employeeOptional = EMPLOYEE_REPOSITORY.findEmployeeByEmail(employee.getEmployeeEmail());
		if(employeeOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		EMPLOYEE_REPOSITORY.save(employee);
	}


	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		boolean exists = EMPLOYEE_REPOSITORY.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Does not exist id");
		}
		EMPLOYEE_REPOSITORY.deleteById(id);
		
	}

}
