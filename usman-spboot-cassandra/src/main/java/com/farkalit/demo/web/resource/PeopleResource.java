package com.farkalit.demo.web.resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farkalit.demo.model.People;
import com.farkalit.demo.model.PeopleKey;
import com.farkalit.demo.repository.PeopleRepository;

@RestController
@RequestMapping("/api")
public class PeopleResource {

	@Autowired
	private PeopleRepository peopleRepo;

	@GetMapping(value = "/peoples", produces = "application/json")
	public List<People> getPeoples() {
		return peopleRepo.findAll();
	}

	@PostMapping(value = "/peoples", produces = "application/json")
	public People savePeoples(@RequestBody People people) {
		// final PeopleKey key = new PeopleKey("John", LocalDateTime.now(),
		// UUID.randomUUID());
		final PeopleKey key = new PeopleKey(people.getKey().getFirstName(), people.getKey().getDateOfBirth(),
				UUID.randomUUID());
		final People p1 = new People(key, people.getLastName(), people.getSalary());
		return peopleRepo.insert(p1);
	}

	/**
	 * URL: http://192.168.43.22:8081/api/peoples/Johny
	 * 
	 * @param firstname
	 * @return
	 */
	@GetMapping(value = "/peoples/{firstname}", produces = "application/json")
	public List<People> findByFirstName(@PathVariable("firstname") String firstname) {
		System.out.println("find by first name");
		List<People> peoples = new ArrayList<>();
		peopleRepo.findByKeyFirstName(firstname).forEach(p -> peoples.add(p));
		return peoples;
	}

	/**
	 * URL: http://192.168.43.22:8081/api/peoples/lastname?name=Usman
	 * 
	 * @param lastname
	 * @return
	 */
	@GetMapping(value = "/peoples/lastname", produces = "application/json")
	public List<People> findByLastName(@RequestParam(value = "name") String lastname) {
		System.out.println("find by last name");
		List<People> peoples = new ArrayList<>();
		peopleRepo.findByLastName(lastname).forEach(p -> peoples.add(p));
		return peoples;
	}

	/**
	 * URL: http://192.168.43.22:8081/api/peoples/Johny/2000-03-15T00:00:00.000
	 * 
	 * @param firstname
	 * @param dateofbirth
	 * @return
	 */
	@GetMapping(value = "/peoples/{firstname}/{dateofbirth}", produces = "application/json")
	public List<People> findByFirstNameAndDateOfBirth(@PathVariable("firstname") String firstname,
			@PathVariable("dateofbirth") String dateofbirth) {
		System.out.println("find by first name and date of birth greater than date");
		List<People> peoples = new ArrayList<>();
		peopleRepo.findByKeyFirstNameAndKeyDateOfBirthGreaterThan(firstname, LocalDateTime.now().minusDays(1))
				.forEach(p -> peoples.add(p));

		return peoples;
	}
}
