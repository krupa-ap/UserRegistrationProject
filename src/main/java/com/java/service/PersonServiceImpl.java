package com.java.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.java.dao.PersonDao;
import com.java.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;

	/**
	 * Registers a user.
	 * 
	 * @param person - (Person)
	 * @return jsonObject - (JSONObject)
	 */
	public JSONObject register(Person person) {
		JSONObject jsonObject = new JSONObject();
		if(StringUtils.isEmpty(person.getFirstname())) {
			jsonObject.put("fnmessage", "Please enter First Name.");
		}
		if(StringUtils.isEmpty(person.getLastname())) {
			jsonObject.put("lnmessage", "Please enter Last Name.");
		}
		if(StringUtils.isEmpty(person.getAddress1())) {
			jsonObject.put("add1message", "Please enter Address1.");
		}
		if(StringUtils.isEmpty(person.getAddress2())) {
			jsonObject.put("add2message", "Please enter Address2.");
		} 
		if(StringUtils.isEmpty(person.getCity())) {
			jsonObject.put("citymessage", "Please enter City.");
		} 
		if(StringUtils.isEmpty(person.getState())) {
			jsonObject.put("statemessage", "Please enter State.");
		} 
		if(StringUtils.isEmpty(person.getZip())) {
			jsonObject.put("zipmessage", "Please enter Zip.");
		} 
		if(!StringUtils.isEmpty(person.getZip()) && !validateZip(person.getZip())) {
			jsonObject.put("ziplenmessage", "Zip must contain only digits and can be either 5 digits or 9 digits long.");
		}
		if(jsonObject.length() == 0) {
			jsonObject.put("register", String.valueOf(personDao.register(person)));
		}
		return jsonObject;
	}

	/**
	 * Validates zip code for United States.
	 * 
	 * @param zip - (String)
	 * @return - (boolean)
	 */
	public boolean validateZip(String zip) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(zip);
	    return matcher.matches();
	}
	
	/**
	 * Get users list
	 * 
	 * @return - ({@literal List<Person>})
	 */
	public List<Person> getPersons() {
		return personDao.getPersons();
	}

}
