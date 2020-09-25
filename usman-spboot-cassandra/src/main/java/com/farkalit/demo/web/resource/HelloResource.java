package com.farkalit.demo.web.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {
	
	
	@GetMapping( value = "/hello", produces = "application/json")
	public String sayHello() {
		return "Hello brother!!!";
	}

}
