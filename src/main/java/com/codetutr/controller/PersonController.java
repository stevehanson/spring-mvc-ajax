package com.codetutr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codetutr.domain.Person;
import com.codetutr.service.PersonService;

@Controller
@RequestMapping("api")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@RequestMapping("person/random")
	@ResponseBody
	public Person randomPerson() {
		return personService.getRandom();
	}
	
	@RequestMapping("person/{id}")
	@ResponseBody
	public Person getById(@PathVariable Long id) {
		return personService.getById(id);
	}
}
