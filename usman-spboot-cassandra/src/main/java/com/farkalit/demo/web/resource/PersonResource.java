package com.farkalit.demo.web.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		return personRepo.findAll();
	}

	
	@PostMapping( value = "/persons", produces = "application/json")
	public Persons savePersons(@RequestBody Persons person){
		 System.out.println("save person...");
		 return personRepo.save(person);
	}
}
