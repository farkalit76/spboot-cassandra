package com.farkalit.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.farkalit.demo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	@Query(allowFiltering = true)
	List<Employee> findByCity(final String city);
}
