package com.github.edveloso.spring.database;

import java.util.List;

import com.github.edveloso.spring.database.domain.Person;

public interface IPersonDAO {
	
	public void addPerson(Person person);

	public List<Person> list();
	
}
