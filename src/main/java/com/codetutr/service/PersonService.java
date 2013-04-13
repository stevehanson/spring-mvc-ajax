package com.codetutr.service;

import com.codetutr.domain.Person;

public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
}
