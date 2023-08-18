package org.simplilearn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.OrderDetails;
import org.simplilearn.entities.Orders;
import org.simplilearn.entities.Product;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.OrderDetailsRepo;
import org.simplilearn.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrdersController {
	
	         OrdersRepository ordersRepo;
	         CartRepository cartRepo;
	         OrderDetailsRepo ordDetRepo;
	         
	         
	         @Autowired
	         public OrdersController(OrdersRepository ordersRepo,CartRepository cartRepo,OrderDetailsRepo ordDetRepo) {
	        	 this.ordersRepo=ordersRepo;
	        	 this.cartRepo=cartRepo;
	        	 this.ordDetRepo=ordDetRepo;
	         }
	         
	         
	         @GetMapping("/paymentGateway")
	         public String showGateway() {
	        	 
	        	 return "paymentGateway";
	         }
	         
	         
	
	              @RequestMapping("/paytheamount")
	              public String payAmount(HttpSession session,HttpServletRequest req,Model model) {
	            	  
	            	  //Check the card details if ok,then proceed for payment and order generation
	 	        	 
	 	        	 String first=req.getParameter("first");
	 	        	 String second=req.getParameter("second");
	 	        	 String third=req.getParameter("third");
	 	        	 String fourth=req.getParameter("fourth");
	 	        	 
	 	        	 String cvv=req.getParameter("cvv");
		        	 if(first.equals(" ")||second.equals(" ")|| third.equals(" ")|| fourth.equals(" "))
		        	 {
		        		 model.addAttribute("msg","Enter a valid card number");
		        		 return "paymentGateway";
		        	 }
		        	 else if(first.length()!=4 || second.length()!=4 || third.length()!=4 || fourth.length()!=4 ) {
		        		 
		        		 model.addAttribute("msg","The card number should be 12 digits long");
		        		 return "paymentGateway";
		        	 }
		        	 else if(cvv.equals(" ")|| cvv.length()!=3) {
		        		 
		        		 model.addAttribute("msg","Enter a valid cvv");
		        		 return "paymentGateway";
		        		 
		        		 
		        	 }
		        	 else {
		        	 
	            	  
	            	  Users user=(Users)session.getAttribute("user1");
	            	  float total_amt=0;
	            	  model.addAttribute("order1",null);
	            	  List<Cart> carts=cartRepo.findByUserid(user.getUid());
	            	  
	           if(carts.size()>0) {
	            	  //Users user=(Users)session.getAttribute("user1");
	            	  Orders order=new Orders();
	            	  order.setUser(user);
	            	  ordersRepo.save(order);
	            	  
	            	 // double total_amt=0;
	            	  
	            	  //List<Cart> carts=cartRepo.findByUserid(user.getUid());
	            	  
	            	  for(Cart c : carts) {
	            		  
	            		OrderDetails ord_detail=new OrderDetails();
	            		
	            		ord_detail.setQty(c.getQty());
	            		
	            		Product product=c.getProd();
	            		
	            		ord_detail.setOrder(order);
	            		
	            		ord_detail.setProduct(product);
	            		
	            		float amount=c.getQty()*(c.getProd().getPrice());
	            		total_amt+=amount;
	            		
	            		ord_detail.setAmount(amount);
	            		
	                    ordDetRepo.save(ord_detail); 
	                    
	                    order.addOrd_Details(ord_detail);
	            	  }
	            	  
	            	  order.setTotal_amount(total_amt);
	            	  ordersRepo.save(order);
	
	            	  
	            	model.addAttribute("order1",order);
	            	model.addAttribute("total_amount",total_amt);
	            	System.out.println("OrdersController Total Amount:"+ total_amt);
	            	
	            	cartRepo.deleteByUserid(user.getUid());
	            	
	           }    //End of if carts.size()>0
	           
	           else {
	        	   
	        	   model.addAttribute("order1",null);
	        	   model.addAttribute("msg","No Payment done as no order generated as there are no products to buy in the Cart. Cart is empty");
	           }
	           
	           
	            	return "payAmount";
	            	
	              }  //End of else for card details verification

	              }   //End of method for payAmount
	              
}
