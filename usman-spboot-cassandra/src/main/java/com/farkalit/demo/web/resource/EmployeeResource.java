package com.farkalit.demo.web.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.LocalDate;
import com.farkalit.demo.model.Employee;
import com.farkalit.demo.model.EmployeeAdd;
import com.farkalit.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping(value = "employees", produces = "application/json")
	public List<Employee> getEmployees() {

		Iterable<Employee> employees = employeeRepo.findAll();
		List<Employee> employeesList = new ArrayList<Employee>();
		employees.forEach(employeesList::add);
		return employeesList;
	}
	
	@PostMapping(value = "employees", produces = "application/json")
	public Employee setEmployee(@RequestBody Employee employee) {
		System.out.println("employee:"+employee);
		//Employee employee =adapt(employeeAdd);
		Employee savedemp = employeeRepo.save(employee);
		return savedemp;
	}
	
	public Employee adapt(EmployeeAdd add) {
		Employee emp = new Employee();
		emp.setEmpId(add.getEmpId());
		emp.setName(add.getName());
		emp.setCity(add.getCity());
		emp.setPhone(add.getPhone());
		emp.setSalary(add.getSalary());
		//LocalDate localDate = new 
		Date date = new Date();
		//emp.setDobirth((LocalDate)date);
		emp.setCreatedTime(add.getCreatedTime());
		
		return emp;
	}
}
