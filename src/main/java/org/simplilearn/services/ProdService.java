package org.simplilearn.services;

import java.util.List;

import org.simplilearn.entities.Product;
import org.springframework.stereotype.Service;


public interface ProdService {
	
	
	              public List<Product> searchProducts(String keyword);
	              
	              public List<Product> sortBySeller(List<Product> products);
	              
	              public List<Product> sortByName(List<Product> products);
	              
	              public List<Product> sortByCategory(List<Product> products);
	              
	              public List<Product> sortByPrice(List<Product> products);

}
