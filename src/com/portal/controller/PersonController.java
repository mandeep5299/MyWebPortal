package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.dao.PersonDaoImpl;
import com.portal.entity.Person;

@Controller
public class PersonController {
	@Autowired
	PersonDaoImpl personDaoImpl;
	
	@RequestMapping(value="/processHomeForm.htm",params="addPerson",method=RequestMethod.POST)
	public ModelAndView showPerson(){
		ModelAndView model = new ModelAndView("Person");
		return model;
	}
	
	@RequestMapping(value="/processHomeForm.htm",params="listPerson",method=RequestMethod.POST)
	public ModelAndView listPerson(){
		List<Person> personList = personDaoImpl.getPersonList();
		ModelAndView model = new ModelAndView("PersonList", "persons", personList);
		return model;
	}
	
	@RequestMapping(value = "/addPerson.htm", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("personData") Person personData){
		ModelAndView model = new ModelAndView("Home");
		personDaoImpl.addPerson(personData);
		return model;
	}

}
