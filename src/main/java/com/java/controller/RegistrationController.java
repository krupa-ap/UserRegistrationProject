package com.java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.domain.Person;
import com.java.service.PersonService;

@Controller
public class RegistrationController {

	@Autowired
	public PersonService personService;

	/**
	 * Redirects to registerUser jsp page.
	 * 
	 * @param m - (Model)
	 * @return - (String)
	 */
	@RequestMapping("/registerUser")  
	public String registerUser(Model m) {
		try {
			m.addAttribute("person", new Person());
			return "registerUser"; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Registers a user.
	 * 
	 * @param request - (HttpServletRequest)
	 * @param response - (HttpServletResponse)
	 * @param person - (Person)
	 * @return mav - (ModelAndView)
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("person") Person person) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("registerUser");
			JSONObject jsonObject = personService.register(person);
			if(jsonObject.optString("register").equalsIgnoreCase("true")) {
				mav.addObject("successmessage", "User is registered successfully.");
			} else {
				mav.addObject("error", jsonObject);
			}
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Displays registered users report.
	 * 
	 * @param m - (Model)
	 * @return - (String)
	 */
	@RequestMapping(value = "/registeredUsersReport")  
	public String viewemp(Model m) {
		try {
			List<Person> list = personService.getPersons();  
			m.addAttribute("list",list);
			return "registeredUsersReport";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
}
