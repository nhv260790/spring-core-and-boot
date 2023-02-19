package com.howtodoinjava.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.model.EmployeeVO;

@Controller
//@RequestMapping(value = "/springmvcexample")
public class LoginController {

	@RequestMapping(value = "/welcome")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "login")
	public String login(Model model) {
		model.addAttribute("employee", new EmployeeVO("viet","12355555"));
		return "login";
	}
}
