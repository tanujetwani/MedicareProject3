package org.simplilearn.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Product;
import org.simplilearn.repositories.ProdRepository;
import org.simplilearn.services.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import antlr.TokenStream;

@Controller
public class ProductController {
	
	      // ProdRepository prodRepo;
	       
	        ProdService prodService;
	        
	       @Autowired
	       public ProductController(ProdService prodService) {
	    	   
	    	   this.prodService=prodService;
	    	   
	    	   
	       }
	       
	       
	       @GetMapping("/searchProd")
	       public String searchProducts(HttpServletRequest req, Model model,HttpSession session) {
	    	   
	    	   String keyword=req.getParameter("searchkey");
	    	   
	    	  // String[] tokens=keyword.split(" ");
	    	   
	  /*  	   String[] tokens=keyword.split("[, . +]");
	    	   
	    	   for(int i =0; i<tokens.length; i++) {
	    	   System.out.println("Token: "+ tokens[i]);
	    	   }
	    	  /* if(keyword.length()==0) {
	    		   System.out.println("Entered if of ProCont");
	    		   //List<Product>products= prodRepo.findAll();
	    		  // model.addAttribute("listofproducts",products);
	    		   model.addAttribute("msg", "No Search Results found");
	    		   return "customerDashboard";
	    	   }*/
/*	    	       List<Product> products= new ArrayList<Product>();
	    	  // now List<Product> products=prodRepo.findByKeyword(keyword);
	    	   for(int i=0 ; i<tokens.length ; i++) { 
	    		   
	    		       System.out.println("i: "+ i);
	    		   
	    	           List<Product> products1=prodRepo.findByKeyword(tokens[i]);
	    	          
	    	           for(int j=0 ;j<products1.size() ; j++) {
	    	        	   
	    	        	   System.out.println("j: "+j);
	    	        	   System.out.println("products1 :"+ products1.get(j).getName());
	                       System.out.println("Length: "+products1.size());    	        	 
	    	           
	    	           if(products.contains(products1.get(j))) {}
	    	           else {
	    			   //products.addAll(prodRepo.findByKeyword(tokens[i]));
	    	        	   products.add(products1.get(j));
	    			   }
	    	           
	    	           
	    	      
	    	           }
	    	   }                         */
	    	   
	    	   
	    	   List<Product> products=prodService.searchProducts(keyword);
	    	   
	    	   if(products.size()>0) {
	    		  // Collections.sort(products,Product.ProdPriceComparartor);   
	    	   model.addAttribute("listofproducts",products);
	    	//   session.setAttribute("sortproducts", products);
	    	   
	    	   }
	    	   
	    	   else {
	    		   model.addAttribute("msg","No search Results found with  keyword " + "'"+keyword+"'" );  
	    		   model.addAttribute("listofproducts",null);
	    	   }
	    	   model.addAttribute("keyword1",keyword);
	    	   session.setAttribute("keyword2",keyword);
	    	// session.setAttribute("sortproducts", products);
	    	   session.setAttribute("sort",0);
	    	   return "customerDashboard";
	    	   
	       }
	       
	       
	       @GetMapping("/sortByPrice")
	       public String sortByPrice(HttpServletRequest req, Model model, HttpSession session) {
	    	   
	    	      String keywd=(String)session.getAttribute("keyword2");
	    	      System.out.println(keywd);
	    	              
	    	   //   List<Product>products=prodRepo.findByKeywordAndSortByPrice(keywd);
	    	      
	    	//      List<Product> productstosort =(List<Product>)session.getAttribute("sortproducts");
	    	      
	    	     List<Product> products=prodService.searchProducts(keywd);
	    	      
	    	     List<Product> productstosort=prodService.sortByPrice(products);
	    	     /* if(productstosort.size()>0) {
	    	      
	    	      Collections.sort(productstosort,Product.ProdPriceComparartor);
	    	      }
	    	      else System.out.println(productstosort);
                  */
	    	     
	    	      model.addAttribute("listofproducts",productstosort);
	    	      model.addAttribute("keyword1",keywd);
	    	      session.setAttribute("sort",1);
	    	     // session.setAttribute("sortedprod",productstosort);
	    	      session.setAttribute("sortedBy","price");
	    	      return "customerDashboard";
	    	      
	       }
	       
	       
	       @GetMapping("/sortByName")
	       public String sortByName(HttpSession session, Model model) {
	    	   
	    	   String keyword=(String)session.getAttribute("keyword2");
	    	   
	    	   System.out.println(keyword);
	    	   
	    	//   List<Product> products=prodRepo.findByKeywordAndSortByName(keyword);
	    	   
	    	//   List<Product> productstosort=(List<Product>)session.getAttribute("sortproducts");
	    	
	    	   List<Product> products=prodService.searchProducts(keyword);
	    	   
	    	   List<Product> productstosort=prodService.sortByName(products);
	    	   /*if(productstosort.size()>0) {
	    		   
	    		Collections.sort(productstosort,Product.ProdNameComparator);   
	    		   
	    	   }*/
	    	   
	    	   model.addAttribute("listofproducts",productstosort);
               model.addAttribute("keyword1",keyword);	
               session.setAttribute("sort",1);
               //session.setAttribute("sortedprod",productstosort);
               session.setAttribute("sortedBy","name");
	    	   return "customerDashboard";
	    	   
	       }
	       
	       
	       @GetMapping("/sortByCategory")
	       public String sortByCategory(HttpSession session,Model model) {
	    	   
	    	   
	    	   String keywrd=(String)session.getAttribute("keyword2");
	    	   System.out.println(keywrd);
	    	   
	    	 //  List<Product> products=prodRepo.findByKeywordAndSortByCategory(keywrd);
	    	   
	    	//   List<Product> productstosort=(List<Product>)session.getAttribute("sortproducts");
	    	  
	    	   List<Product> products=prodService.searchProducts(keywrd);
	    	
	    	   List<Product> productstosort=prodService.sortByCategory(products);
	    	   /*   if(productstosort.size()>0) {
	    		   
	    		   Collections.sort(productstosort,Product.ProdCategoryComparator);
	    	   }
	    	   
	    	   */
	    	   model.addAttribute("listofproducts",productstosort);
	    	   model.addAttribute("keyword1",keywrd);
	    	   session.setAttribute("sort",1);
	    	   //session.setAttribute("sortedprod",productstosort);
	    	   session.setAttribute("sortedBy","category");
	    	   return "customerDashboard";
	       }
	       
	       
	       @GetMapping("/sortBySeller")
	       public String sortbyseller(HttpSession session, Model model) {
	    	   
	    	   String keyword=(String)session.getAttribute("keyword2"); 
	    	   System.out.println(keyword);
	    	   
	    	//   List<Product> productstosort=(List<Product>)session.getAttribute("sortproducts");
	    	   List<Product> products=prodService.searchProducts(keyword); 
	    	   
	    	   List<Product> productstosort=prodService.sortBySeller(products);
	    	   /*if(productstosort.size()>0) {
	    		   
	    		   Collections.sort(productstosort,Product.ProdSellerComparator);
	    	   }*/
	    	   
	    	   model.addAttribute("listofproducts",productstosort);
	    	   model.addAttribute("keyword1",keyword);
               session.setAttribute("sort",1);
              // session.setAttribute("sortedprod",productstosort);
               session.setAttribute("sortedBy","Seller");
	    	   return "customerDashboard";
	    	   
	       }

}
