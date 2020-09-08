package com.java.dao;

import java.util.List;

import com.java.domain.Person;

public interface PersonDao {

	public boolean register(Person person);

	public List<Person> getPersons();
}
