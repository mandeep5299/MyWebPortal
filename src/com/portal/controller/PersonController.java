package com.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.dao.LoginDaoImpl;
import com.portal.dao.PersonDaoImpl;
import com.portal.entity.Login;
import com.portal.entity.Person;

@Controller
public class PersonController {
	@Autowired
	PersonDaoImpl personDaoImpl;
	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	@RequestMapping(value="/processHomeForm.htm",params="addPerson",method=RequestMethod.POST)
	public ModelAndView showPerson(){
		ModelAndView model = new ModelAndView("Person");
		return model;
	}
	
	@RequestMapping(value="/processHomeForm.htm",params="listPerson",method=RequestMethod.POST)
	public ModelAndView listPerson(){
		List<Person> personList = personDaoImpl.getPersonList();
		ModelAndView model = new ModelAndView("PersonList", "personList", personList);
		return model;
	}
	
	@RequestMapping(value = "/addPerson.htm", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("personData") Person personData){
		ModelAndView model = null;
		System.out.println("coming here >>" + personData.getLogin().getUsername());
		Login loginObj = personData.getLogin();
		model = new ModelAndView("Home");
		loginDaoImpl.addUserLogin(loginObj);
		personDaoImpl.addPerson(personData);
		return model;
	}

}
