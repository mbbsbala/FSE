package com.fse.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("assignment8")
public class GreetingResource {

	@GetMapping
	public String sayHello() {
		return "Hello! welcome to FSE docker assignment";
	}
}
