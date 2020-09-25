package com.farkalit.demo.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farkalit.demo.model.Persons;
import com.farkalit.demo.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonResource {
	
	@Autowired
	private PersonRepository personRepo;

	@GetMapping( value = "/persons", produces = "application/json")
	public List<Persons> getPersons(){
		System.out.println("find person...");
		return personRepo.findAll();
	}

	
	@PostMapping( value = "/persons", produces = "application/json")
	public Persons savePersons(@RequestBody Persons person){
		 System.out.println("save person...");
		 return personRepo.save(person);
	}
	
	@PutMapping( value = "/persons", produces = "application/json")
	public Persons updatePersons(@RequestBody Persons person){
		 System.out.println("update person...");
		 return personRepo.save(person);
	}
	
	@DeleteMapping( value = "/persons", produces = "application/json")
	public String deletePersons(@RequestBody Persons person){
		 System.out.println("delete person...");
		 personRepo.delete(person);
		 return "date deleted";
	}
}
