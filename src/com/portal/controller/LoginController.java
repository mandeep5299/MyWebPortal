package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.dao.LoginDaoImpl;
import com.portal.entity.Login;
import com.portal.validator.LoginValidator;

@Controller
public class LoginController {

	@Autowired
	LoginDaoImpl loginDaoImpl;
	@Autowired
	LoginValidator loginValidator;

	@RequestMapping(value = "/" , method = RequestMethod.POST)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@RequestMapping(value = "/Home.htm", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("loginData") Login loginData, BindingResult result) {
		ModelAndView model = null;
		loginValidator.validate(loginData, result);
		if(result.hasErrors()){
			 model = new ModelAndView("login");
		}
		if (loginDaoImpl.validateUser(loginData)) {
			model = new ModelAndView("Home" , "loginDetails", loginData);
		}else{
			model = new ModelAndView("login");
		}
		return model;
	}

}
