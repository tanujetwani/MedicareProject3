package org.simplilearn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/register")
	public String registerShow() {
		return "register";
	}
	
	
	@GetMapping("/login")
	public String  loginShow() {
		return "login";
	}

	 @GetMapping("/logout")
	 public String logShow() {
		
		return "home"; 
	 }

}
