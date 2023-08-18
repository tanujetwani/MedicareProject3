package org.simplilearn.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Product;
import org.simplilearn.repositories.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	          
	
	         ProdRepository prodRepo;
	         
	         @Autowired
	         public AdminController(ProdRepository prodRepo) {
	        	 this.prodRepo=prodRepo;
	         }
	
	        @GetMapping("/addmedicine")
	        public String addMedi() {
	        	return "addmedicine";
	        	
	        }
	        
	        @PostMapping("/addmed")
	        public String addMedicine(HttpServletRequest req,Model model) {
	        	
	             String name=req.getParameter("name");
	             String category=req.getParameter("category");
	             String description=req.getParameter("description");
	             String seller=req.getParameter("seller");
	             String price1=req.getParameter("price");
	             float price=0;
	             if(price1.equals("")) {}
	             else {
	             price=Float.parseFloat(price1);
	             }
	             boolean isAvailable=Boolean.parseBoolean(req.getParameter("isAvailable"));
	             
                  Product product1=new Product();	
                  product1.setName(name);
                  product1.setCategory(category);
                  product1.setDescription(description);
                  product1.setSeller(seller);
                  product1.setPrice(price);
                  product1.setAvailable(isAvailable);
                  
                  prodRepo.save(product1);
                  model.addAttribute("msg", "Medicine " + name + " Added successfully");
                  return "addmedicine";
	        }

	        
	        @GetMapping("/removemedicine")
	        public String remMedicine() {
	        	return "remMedicine";
                	        	
	        }
	        
	        
	        @RequestMapping("/removeByid")
	        public String remByid(HttpServletRequest req,Model model) {
	            
	        	int pid=Integer.parseInt(req.getParameter("id"));
	            
	        	int exception=0,count=-1;
	        	try {
	        	 count=prodRepo.deleteById(pid);
	        	
	        	}
	        	catch(Exception e){
	        		
	        		exception=1;
	        	}
	        	
	        	if(exception==1) {
	        		
	        		model.addAttribute("msg","Medicine with Id "+ pid + " cannot be deleted as there is an entry of this medicine in order_details table ");
	        	
	        	}
	        	else if(count==0) {
	        		
	        		model.addAttribute("msg","Medicine with Id "+pid+ " does not exist in store");
	        	}
	        	
	        	else {
	        		
	        	       model.addAttribute("msg","Medicine with ID "+ pid + " deleted successfully");	
	        	}
	        	
	        	return "remMedicine";
	        }
	        
	        
	        
	        @RequestMapping("/remByCategory")
	        public String remByCategory(HttpServletRequest req, Model model) {

	                String category=req.getParameter("category");
	                 
	                int exception=0,count=-1,count1=0;
	                
	                try {
	                	count1=prodRepo.findByCategory(category);
	                	System.out.println("Count1: findbycat "+ count1);
	                	count=prodRepo.deleteByCategory(category);
	                	System.out.println("Count: delbycat "+ count);
	                }
	               catch(Exception e) {
	            	   System.out.println(e);
	            	   
	            	   exception=1;
	            	   System.out.println("Exception: "+ exception);
	               }
	            if(exception==1) {
	            	
	            	model.addAttribute("msg", "Medicines with category "+ category + " could not be  deleted as there is an entry of medicines in the order_details table ");
	            }
	            
	            
	            else if(count==0) {
	            	
	                 model.addAttribute("msg", "Medicines with category "+ category + " does not exist in the store");	
	            }
	            
	            else {
	            	
	            	model.addAttribute("msg"," Medicines with category "+ category + " deleted successfully");
	            }
	            
	            return "remMedicine";
	        
	        }
	        
              
	        
	        @RequestMapping("/remByName")
	        public String remByName(HttpServletRequest req, Model model) {
	        	
	        	String name=req.getParameter("name");
	        	
	        	int exception=0, count=-1;
	        	
	        	try {
	        		
	        		count=prodRepo.deleteByName(name);
	        	}
	        	catch(Exception e) {
	        		
	        		exception=1;
	        	}
	        	
	        	if(exception==1) {
	        		
	        		model.addAttribute("msg", "The Medicine with name "+ name + " could not be deleted as there is an entry of this medicine in order_details table");
	        	}
	        	
	        	else if (count==0) {
	        		
	        		model.addAttribute("msg", "The Medicine with name " + name + " does not exist in store");
	        	}
	        	
	        	else {
	        		
	        		model.addAttribute("msg", "Medicine with name "+ name + " deleted successfully");
	        	}
	        	
	        	return "remMedicine";
	        }
	        
	        
	        
	        @GetMapping("editdetails")
	        public String editDetails(Model model) {
                
	        	model.addAttribute("product2",null);
	        	return "editDetails";               
	           	
	        	
	        	
	        }
	        
	        
	        @GetMapping("/searchwithid")
            public String searchwithId(HttpServletRequest req,HttpSession session,Model model) {
	        	
	        	int pid=Integer.parseInt(req.getParameter("pid"));
	        	int exception=0;
	        	session.setAttribute("id",pid);
	        	Product product=new Product();
	        	try {
	        	 product=prodRepo.findById(pid).get();
	        	}
	        	catch (Exception e) {
	        		
	        		System.out.println(e);
	        		exception=1;
	        		System.out.println("Exception: "+ exception);
	        	}
	        	//session.setAttribute("id",pid);
	        	/*if(product!=null) {
	        	model.addAttribute("product2",product);
	        	}
	        	
	        	else {
	        		model.addAttribute("msg1", "Medicine with Id "+ pid+ " does not exist in store");
	        	}*/
	        	
	        	if(exception==1) {
	        		model.addAttribute("msg1", "Medicine with Id "+ pid+ " does not exist in store");
	        	}
	        	else {
	        		model.addAttribute("product2",product);
	        	}
	        	
	        	return"editDetails";
	        }

	        
	        @RequestMapping("/editDet")
	        public String editDet(HttpServletRequest req,Model model,HttpSession session) {
             
	        	String name=req.getParameter("name");
	            
	        	String category=req.getParameter("category");
	            String description=req.getParameter("description");
	            String seller=req.getParameter("seller");
	            //double price=Double.parseDouble(req.getParameter("price"));
	            String price1=req.getParameter("price");
	            
                    int id=(Integer)session.getAttribute("id");
                    Product product=prodRepo.findById(id).get();
                    
                    
                    if(name.equals("")) {System.out.println("If Name: "+ name);}
                    else {
                    	System.out.println("Else name :"+ name);
                    	product.setName(name);}
                    
                    if(category.equals(" ")) {}
                    else{ product.setCategory(category);}
                    
                    if(description.equals("")) {
                    	System.out.println("If Description: "+ description);
                    }
                    else { 
                    	System.out.println("Else Description: "+ description);
                    	product.setDescription(description); }
                    
                    if (seller.equals("")) {System.out.println("If Seller: "+ seller);
                	}
                    else {System.out.println("Else seller:"+ seller);
                    	product.setSeller(seller); }
                    
                    if(price1.equals("")) {System.out.println("If price: "+ price1);}
                    else {
                    	float price=Float.parseFloat(req.getParameter("price"));
                    	product.setPrice(price);}
	        
	                 prodRepo.save(product);
	                 
	                 model.addAttribute("msg1", "Details of medicine with Id "+ id + " edited .");
                    
                      
                     return "editDetails";
	        
                    }
                    
	        
	        
	        
	        @GetMapping("/gotoadminhome")
	        public String adminHome() {
	        	return "adminDashboard";
	        }
	        
	        
	        @GetMapping("/enablemedicine")
	        public String enablemedicine(Model model) {
	        	
	        	model.addAttribute("product2",null);
	        	return "enablemedicine";
	        }
	        
	        
	        @GetMapping("/searchwithid2")
            public String searchwithId2(HttpServletRequest req,HttpSession session,Model model) {
	        	
	        	int pid=Integer.parseInt(req.getParameter("pid"));
	        	int exception=0;
	        	session.setAttribute("id1",pid);
	        	Product product=new Product();
	        	try {
	        	 product=prodRepo.findById(pid).get();
	        	}
	        	catch (Exception e) {
	        		
	        		System.out.println(e);
	        		exception=1;
	        		System.out.println("Exception: "+ exception);
	        	}
	        	//session.setAttribute("id",pid);
	        	/*if(product!=null) {
	        	model.addAttribute("product2",product);
	        	}
	        	
	        	else {
	        		model.addAttribute("msg1", "Medicine with Id "+ pid+ " does not exist in store");
	        	}*/
	        	
	        	if(exception==1) {
	        		model.addAttribute("msg1", "Medicine with Id "+ pid+ " does not exist in store");
	        	}
	        	else {
	        		model.addAttribute("product2",product);
	        		//session.setAttribute("product3",product);
	        	}
	        	
	        	return "enablemedicine";
	        }
	        
	        
	        @PostMapping("/enableordisable")
	        public String enableDisable(HttpSession session, HttpServletRequest req, Model model) {
	        	  System.out.println("Entered EnableorDisable");
                  int pid=(Integer)session.getAttribute("id1");
                  Product product=prodRepo.findById(pid).get();
                    
                  boolean enable=Boolean.parseBoolean(req.getParameter("enable"));
                  System.out.println("Enable :");
                  product.setAvailable(enable);
                  
                  prodRepo.save(product);
	              
                  if(enable==true) {
                  model.addAttribute("msg1","Enabled the medicine with id "+ pid);
                  }
                  else {
                	  model.addAttribute("msg1","Disabled the medicine with id "+pid);
                  }
                  
                  return "enablemedicine"; 
	        }
}