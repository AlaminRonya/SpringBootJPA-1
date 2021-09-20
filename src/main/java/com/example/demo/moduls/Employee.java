package com.example.demo.moduls;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity(name = "Employee")
@Table(
		name = "employee_tb",
		uniqueConstraints = {
				@UniqueConstraint(name = "employee_email_unique", columnNames = "employee_email")
		}
	)
public class Employee {
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence"
			)
	@Column(name = "employee_id",
				updatable = false
			)
	private long employeeId;
	
	@Column(name = "employee_first_name",
				nullable =  false,
				columnDefinition = "TEXT"
			)
	private String employeeFirstName;
	
	@Column(name = "employee_last_name",
				nullable =  false,
				columnDefinition = "TEXT"
			)
	private String employeeLastName;
	
	@Column(name = "employee_email",
			nullable =  false,
			columnDefinition = "TEXT"
			)
	private String employeeEmail;
	
	@Column(name = "employee_age")
	@Transient
	private int employeeAge;
	
	@Column(name = "employee_dob")
	private LocalDate dob;
	
	public Employee() {
		
	}

	public Employee(String employeeFirstName, String employeeLastName, String employeeEmail, LocalDate dob) {
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.dob = dob;
	}

	public Employee(long employeeId, String employeeFirstName, String employeeLastName, String employeeEmail, LocalDate dob) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeEmail = employeeEmail;
		this.dob = dob;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	
	public int getEmployeeAge() {
		//return employeeAge;
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeEmail=" + employeeEmail + ", employeeAge=" + employeeAge + ", dob="
				+ dob + "]";
	}
	
	
	
	
	

}
