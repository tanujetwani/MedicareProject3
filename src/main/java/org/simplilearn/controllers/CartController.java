package org.simplilearn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Cart;
import org.simplilearn.entities.Product;
import org.simplilearn.entities.Users;
import org.simplilearn.repositories.CartRepository;
import org.simplilearn.repositories.ProdRepository;
import org.simplilearn.repositories.UserRepository;
import org.simplilearn.services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	       CartRepository cartRepo;
	       UserRepository userRepo;
	       ProdRepository prodRepo;
	       ProdService  prodService;
	       
	       
	       @Autowired
	       public CartController(CartRepository cartRepo,UserRepository userRepo, ProdRepository prodRepo, ProdService prodService) {
	    	   
	    	   this.cartRepo=cartRepo;
	    	   this.userRepo=userRepo;
	    	   this.prodRepo=prodRepo;
	    	   this.prodService=prodService;
	       }
	       
	       
	       @PostMapping("/addToCart")
	       public String addtocart(HttpServletRequest req,Model model,HttpSession session) {
	    	   
	    	          System.out.println("Entered addToCart");
	
	                  int prodid=Integer.parseInt(req.getParameter("pid"));
	                  System.out.println("Prod id: "+ prodid);
	                  
	                  Users cuser=(Users)session.getAttribute("user1");
	                  System.out.println("User name: "+ cuser.getUname());
	                  
	                  Product product=prodRepo.findById(prodid).get();
	                 // Product product=prodRepo.getById(prodid);
	                 
	                  System.out.println("Product : "+ product.getName());
	                  
	               if(product.isAvailable()==true) {
	            	   
	               
	                  int qty=0;
	                  //Cart cart1=new Cart();
	                  Cart cart=cartRepo.findByProdidAndUserid(prodid,cuser.getUid());
	                  
	                  
	                  
	                  if(cart!=null) {
	                	  
	                	  System.out.println("Cart not null");
	                	  
	                	  qty=cart.getQty();
	                	  qty++;
	                	  cart.setQty(qty);
	                	  cartRepo.save(cart);
	                	  
	                  }
	                  
	                  else {
	                	
	                	  System.out.println("Cart Null");
	                	  qty=1;
	                	  
	                	  Cart cart1=new Cart();
	                	  cart1.setProd(product);
	                	  cart1.setUser(cuser);
	                	  cart1.setQty(qty);
	                	  cartRepo.save(cart1);
	                	 
	                  }
	               
	                  model.addAttribute("msg2","Added "+ product.getName()+ "  to cart");
	               }//End of if isAvailable=true
	               
	               else {
	            	   
	            	   model.addAttribute("msg2","Cannot add Product "+ product.getName()+ " to cart as it is diabled");   
	               }
	               
	               String keyword=(String)session.getAttribute("keyword2");   
	               List<Product> products=prodService.searchProducts(keyword);
	               
	               int sort=(Integer)session.getAttribute("sort");
	               String sortedBy=(String)session.getAttribute("sortedBy");
	               List<Product> products2=new ArrayList<Product>();
	               
	               if(sort==1) {
	            	
	            	    switch(sortedBy) {
	            	    
	            	    case "price":{ products2=prodService.sortByPrice(products);
	            	                    break;
	            	                 }
	            	    
	            	    case "name":{products2=prodService.sortByName(products);
	            	                   break;
	            	    
	            	                }
	            	    
	            	    case "category": {products2=prodService.sortByCategory(products);
	            	                      break;
	            	                     }
	            	    
	            	    case "Seller": { products2=prodService.sortBySeller(products);
	            	                     break;
	            	                    }
	            	    
	            	    
	            	    }  //End of switch case
	            	   //List<Product> products1=(List<Product>)session.getAttribute("sortedprod");
	            	   model.addAttribute("listofproducts",products2);
	               }
	               else {
	               model.addAttribute("listofproducts",products);
	               }
	               
	               model.addAttribute("keyword1",keyword);
	              // model.addAttribute("msg2","Added "+ product.getName()+ "  to cart");
	               return "customerDashboard";
	               
                   
	       }
	       
	       
	       
	       @PostMapping("/removefromcart")
	       public String removefromcart(HttpSession session, Model model,HttpServletRequest req) {
	    	   
	    	   int pid=Integer.parseInt(req.getParameter("pid"));
	    	   Users cuser=(Users)session.getAttribute("user1");
	    	   
	    	   Product product=prodRepo.findById(pid).get();
	    	   
	    	
	    	   int count=cartRepo.deleteByProdidAndUserid(pid, cuser.getUid());
               
	    	   if(count>0) {
	    	   model.addAttribute("msg2", "Removed "+ product.getName() + " from cart");
	    	   }
	    	   else {
	    		   model.addAttribute("msg2"," Product "+ product.getName()+ " is not present in cart to remove");
	    	   }
	    	   
	    	   String keyword=(String)session.getAttribute("keyword2");
	    	   
	    	   List<Product> products=prodService.searchProducts(keyword);
	    	
	    	   int sort=(Integer)session.getAttribute("sort");
	    	   String sortedBy=(String)session.getAttribute("sortedBy");
	    	   List<Product> products2=new ArrayList<Product>();
	    	   
               if(sort==1) {
            	   
             	    switch(sortedBy) {
	            	    
	            	    case "price":{ products2=prodService.sortByPrice(products);
	            	                    break;
	            	                 }
	            	    
	            	    case "name":{products2=prodService.sortByName(products);
	            	                   break;
	            	    
	            	                }
	            	    
	            	    case "category": {products2=prodService.sortByCategory(products);
	            	                      break;
	            	                     }
	            	    
	            	    case "Seller": { products2=prodService.sortBySeller(products);
	            	                     break;
	            	                    }
	            	    
	            	    
	            	    }  //End of switch case   
            	   
            	   
            	   
            	   
            	//   List<Product> products1=(List<Product>)session.getAttribute("sortedprod");
            	   model.addAttribute("listofproducts",products2);
               }
               else {
                       model.addAttribute("listofproducts",products);
               }
	    	   //model.addAttribute("listofproducts",products);
               model.addAttribute("keyword1",keyword);
	    	    
               return "customerDashboard";
	    	   
	       }
	       
	       
	       @GetMapping("/viewCart")
	       public String viewcart(HttpSession session, Model model) {
	    	   
	    	   Users cuser=(Users)session.getAttribute("user1");
	    	   List<Cart> carts=cartRepo.findByUserid(cuser.getUid());
	    	   if(carts!=null) {
	           model.addAttribute("listofcarts",carts);
	    	   }
	    	   else {
	    		   //model.addAttribute("listofcarts",null);
	    		   model.addAttribute("msg","Cart is Empty");
	    	   }
	    	   
	           return "viewcart";
	       
	       }
	       
	       
	       @RequestMapping("/remfromcart")
	       public String remfrmcart(HttpSession session,Model model,HttpServletRequest req) {
	    	
	    	   Users user=(Users)session.getAttribute("user1");
	    	   
	    	   int pid=Integer.parseInt(req.getParameter("pid"));
	    	   
	    	   Product product=prodRepo.findById(pid).get();
	    	   
	    	   int count=cartRepo.deleteByProdidAndUserid(pid,user.getUid());
	    	   
	    	   List<Cart> carts=cartRepo.findByUserid(user.getUid());
	    	   
	    	   model.addAttribute("listofcarts",carts);
	    	   model.addAttribute("msg","Removed "+ product.getName()+ " from cart" );
	    	 
	    	   return "viewcart";
	    	   
	    	   
	       }
	       
	       
	       @RequestMapping("/gotosearchform")
	       public String gotosearchform(Model model) {
	    	   
	    	   model.addAttribute("listofproducts",null);
	    	   return "customerDashboard";
	       }
	       
	       
	       
	       
	       
	       
	       
	       @RequestMapping("/buytheproducts")
	       public String buyproducts(HttpSession session,Model model) {
	    	   
	    	   Users cuser=(Users)session.getAttribute("user1");
	    	   List<Cart> carts=cartRepo.findByUserid(cuser.getUid());
	    	   
	    	   float total_amt=0;
	    	   
	    	   if(carts!=null) {
	    	   model.addAttribute("listofcarts",carts);
	    	   
	    	   for(Cart c:carts) {
	    		   total_amt=total_amt+((c.getQty())*(c.getProd().getPrice()));
	    	   }
	    	   
	    	   model.addAttribute("total_amount",total_amt);
	    	   session.setAttribute("tot_amt",total_amt);
	    	   System.out.println("Total Amount :"+ total_amt);
	    	   
	     }
	    	   else {
	    		   //model.addAttribute("listofcarts",null);
	    		   model.addAttribute("msg1","Cannot buy products as Cart is Empty");
	    	   }
	    	   
	    	   return "buyproducts";
	       }
	       
	       
}
