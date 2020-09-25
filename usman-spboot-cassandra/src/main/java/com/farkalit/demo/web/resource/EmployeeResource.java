package com.farkalit.demo.web.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farkalit.demo.model.Employee;
import com.farkalit.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository employeeRepo;

	@GetMapping(value = "employees", produces = "application/json")
	public List<Employee> getEmployees() {
		System.out.println("safetchve employee:");
		Iterable<Employee> employees = employeeRepo.findAll();
		List<Employee> employeesList = new ArrayList<Employee>();
		employees.forEach(employeesList::add);
		return employeesList;
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	@PostMapping(value = "employees", produces = "application/json")
	public Employee setEmployee(@RequestBody Employee employee) {
		System.out.println("save employee:" + employee);
		Employee savedemp = employeeRepo.save(employee);
		return savedemp;
	}

}
