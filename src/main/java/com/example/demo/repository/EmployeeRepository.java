package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.moduls.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	@Query("SELECT s FROM Employee s WHERE s.employeeEmail= ?1")
	Optional<Employee> findEmployeeByEmail(String email);

}
