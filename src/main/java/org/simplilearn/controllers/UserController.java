package org.simplilearn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Users;
import org.simplilearn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	        UserRepository userRepo;
	
	        
	        
	        @Autowired
	        public UserController(UserRepository userRepo) {
	        	
	        	this.userRepo=userRepo;
	        }
	        
	        
	
          	   @PostMapping("/registerUser")
	      public String registerUser(HttpServletRequest req,Model model) {
		  
		  String uname=req.getParameter("name");
		  String upwd=req.getParameter("pwd");
		  String address=req.getParameter("address");
		  String phone=req.getParameter("phone");
		  String email=req.getParameter("email");
		  String userType=req.getParameter("uType");
		  
		  if(uname.equals("")) {
			model.addAttribute("msg", "Enter a valid username ") ;
			return "register";
		  }
		  else if(upwd.equals("")){
			  model.addAttribute("msg","Enter a valid password");
			  return "register";
		  }
		  else if (userRepo.findAllPwds().contains(upwd)) {
			  
			  model.addAttribute("msg","This password is already in use.Please try another one");
			  return "register";
		  }
		  
		  
		  Users user=new Users();
		  user.setUname(uname);
		  user.setUpwd(upwd);
		  user.setAddress(address);
		  user.setPhone(phone);
		  user.setEmail(email);
		  user.setUserType(userType);
		  
		  userRepo.save(user);
		  
		  model.addAttribute("msg", "User "+ uname + " registered successfully");
		  
		  return "home";
		  
	  }
	  
	  
	  @GetMapping("/loginUser")
	  public String login(HttpServletRequest req,HttpSession session, Model model) {
		  
		  System.out.println("Entered login");
		  String name=req.getParameter("uname");
		  String passwd=req.getParameter("pwd");
		  
		  Users user=userRepo.findByUnameAndUpwd(name,passwd);
		  
		  
		  
		  if(user!=null) {
			 
			  System.out.println("Entered if");
			  session.setAttribute("user1",user);
			  
			  if(user.getUserType().equals("Customer")) {
			        
				  System.out.println("Entered Cust");
				  model.addAttribute("listofproducts",null);
				  
				  return "customerDashboard";
			  }
			  
			  else if(user.getUserType().equals("Admin")) {
				  System.out.println("Eneterd Admin");
				  return "adminDashboard"; 
			  }
			  
			  
		  }
		  
		 // else {
			  
			  model.addAttribute("msg", "Incorrect Username or Password");
			  return "login";
		    //  }
		
		//  return "login";
	  }
		  

}
