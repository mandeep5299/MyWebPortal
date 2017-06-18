package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.dao.LoginDaoImpl;
import com.portal.dao.PersonDaoImpl;
import com.portal.dao.PersonSecurityMappingDaoImpl;
import com.portal.dao.SecurityQuestionsDaoImpl;
import com.portal.entity.Login;
import com.portal.entity.Person;
import com.portal.entity.PersonSecurityQuestionMapping;
import com.portal.entity.SecurityQuestions;

@Controller
public class PersonController {
	@Autowired
	PersonDaoImpl personDaoImpl;
	@Autowired
	LoginDaoImpl loginDaoImpl;
	@Autowired
	SecurityQuestionsDaoImpl securityQuestionsDaoImpl;
	@Autowired
	PersonSecurityMappingDaoImpl personSecurityMappingDaoImpl;

	@RequestMapping(value = "/processHomeForm.htm", params = "addPerson", method = RequestMethod.POST)
	public ModelAndView showPerson() {
		List<SecurityQuestions> securityQuestionsList = securityQuestionsDaoImpl.getAllSecurityQuestionsList();
		ModelAndView model = new ModelAndView("Person", "securityQuestionsList", securityQuestionsList);
		model.addObject("personData", new Person());
		return model;
	}

	@RequestMapping(value = "/processHomeForm.htm", params = "listPerson", method = RequestMethod.POST)
	public ModelAndView listPerson() {
		List<Person> personList = personDaoImpl.getPersonList();
		ModelAndView model = new ModelAndView("PersonList", "personList", personList);
		return model;
	}

	@RequestMapping(value = "/addPerson.htm", method = RequestMethod.POST)
	public ModelAndView addPerson(@ModelAttribute("personData") Person personData, BindingResult result){
		ModelAndView model = null;
		if(result.hasErrors()){
			System.out.println(result);
			model = new ModelAndView("Person");
					return model;
		}
		Login loginObj = personData.getLogin();
		loginDaoImpl.addUserLogin(loginObj);
		personDaoImpl.addPerson(personData);
		List<PersonSecurityQuestionMapping> personSecurityQuestionMappingList =  personData.getPersonSecurityQuestionMapping();
		if(null != personSecurityQuestionMappingList && personSecurityQuestionMappingList.size()>0){
			for(PersonSecurityQuestionMapping personSecurityQuestionMapping : personSecurityQuestionMappingList){
				personSecurityQuestionMapping.setPerson(personData);
				personSecurityMappingDaoImpl.addPersonSecurityMapping(personSecurityQuestionMapping);
			}
		}
		model = new ModelAndView("Home");
		return model;
	}

}
