//package com.example.demo.insertvalue;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.demo.moduls.Employee;
//import com.example.demo.repository.EmployeeRepository;
//
//@Configuration
//public class InsertClass {
//	@Autowired
//	private EmployeeRepository employeeRepository;
////	
////	List<Employee> employees = List.of(
////			new Employee("Md. ", "Al Amin", "hprony12@gmail.com", 22),
////			new Employee("Md. ", "Jahangir Alam", "jahangir@gmail.com", 24)
////			);
////	Employee emp = new Employee("Md. ", "Jahangir Alam", "jahangir@gmail.com", 24);
////	@PostMapping("/p")
////	public void save() {
////		System.out.print("alla");
////		employeeRepository.save(emp);
////		
////	}
//	
//	
//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args ->{
//			Employee emp = new Employee("Md. ", "Al Amin", "hprony12@gmail.com",LocalDate.of(2000, Month.JANUARY, 15));
//			
//			Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(emp.getEmployeeEmail());
//			
//			System.out.println("employeeOptional " +employeeOptional);
//			if(employeeOptional.isPresent()) {
//				throw new IllegalStateException("Email taken");
//			}
//			employeeRepository.save(emp);
//		};
//		
//	};
//
//}
