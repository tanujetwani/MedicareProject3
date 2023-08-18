package org.simplilearn.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.simplilearn.entities.Product;
import org.simplilearn.repositories.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdServiceImpl implements ProdService {
	
	           ProdRepository prodRepo;
	           
	           
	           @Autowired
	           public ProdServiceImpl(ProdRepository prodRepo){
	        	   
	        	   this.prodRepo=prodRepo;
	        	   
	           }

	@Override
	public List<Product> searchProducts(String keyword) {
		
		String[] tokens=keyword.split("[, . +]");
		
		for(int i =0; i<tokens.length; i++) {
	    	   System.out.println("Token: "+ tokens[i]);
	    	   }
		
		List<Product> products= new ArrayList<Product>();
		
		for(int i=0 ; i<tokens.length ; i++) { 
 		   
		       System.out.println("i: "+ i);
		   
	           List<Product> products1=prodRepo.findByKeyword(tokens[i]);
	           
	           //now 
	           //String token2="";
	           List<Product> products3=new ArrayList<Product>();
	           
	           //If the search keyword contains a number like for eg Vicks500 then remove 500 and search for vicks.So Display Vicks also.
	           if(tokens[i].matches(".*\\d.*") && !tokens[i].matches("^[0-9]+$")) {
	        	   System.out.println("Entered if of number");
	        	  tokens[i]= tokens[i].replaceAll("[0-9]","");
	           
	           
	           System.out.println("Token without number:" + tokens[i]);
	            products3=prodRepo.findByKeyword(tokens[i]);
	           //int c=0;
	           System.out.println("Products3 size:"+ products3.size());
	           }
	           
	           for(int j=0;j<products1.size() ; j++) {
	        	   
	        	   System.out.println("j: "+j);
	        	   System.out.println("products1 :"+ products1.get(j).getName());
                System.out.println("Length: "+products1.size());    	        	 
	           
	           if(products.contains(products1.get(j))) {}
	           else {
			   //products.addAll(prodRepo.findByKeyword(tokens[i]));
	        	   products.add(products1.get(j));
			   }
	           
	         
	      
	           } //End of inner for1
	           
	           for(int c=0;c<products3.size();c++) {
	           
	        	   if(products.contains(products3.get(c))) {}
	 	          else {
	 	        	    products.add(products3.get(c));  
	 	          }
	        	   
	           }   //End of inner for2
	           
		}//End of outer for       

		return products;
	}
	
	
	      public List<Product> sortBySeller(List<Product> products){

                   if(products.size()>0) {
	                      
                	   Collections.sort(products,Product.ProdSellerComparator);
	      
                   }
                   
                   return products;
                   
	      }   
	      
	      
	      public List<Product> sortByCategory(List<Product> products){
	    	  
	    	  if(products.size()>0) {
	    		  
	    		  Collections.sort(products,Product.ProdCategoryComparator);
	    	  }
	    	  
	    	  return products;
	      }
	 
	      
	      
	      public List<Product> sortByName(List<Product> products){
	    	  
	    	  
	    	  if(products.size()>0) {
	     
	    	          Collections.sort(products,Product.ProdNameComparator);
	    	  
	    	  }
	    	  
	    	  return products;
	      }
	      
	      
	      public List<Product> sortByPrice(List<Product> products){
	    	  
	    	  if(products.size()>0) {
	    		  
	    		  Collections.sort(products,Product.ProdPriceComparartor);
	    	  }
	    	  
	    	  return products;
	      }
	      
}     
