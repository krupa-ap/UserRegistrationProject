package com.java.service;

import java.util.List;

import org.json.JSONObject;

import com.java.domain.Person;

public interface PersonService {

	public JSONObject register(Person person);

	public List<Person> getPersons();
}
