package org.simplilearn.entities;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Product {
	
	
	             @Id
                  @GeneratedValue(strategy=GenerationType.IDENTITY)
                  private int pid ;

                  private String name;
    
                  private String seller;
    
                  private String description;
    
                  private String category;
    
                  private float price;
                  
                  @Column(nullable=false,columnDefinition="TINYINT(1)")
                  private boolean isAvailable; 
                  
                  
                  //Default Constructor
                  public Product() {}

                  //Getters and Setters
				public int getPid() {
					return pid;
				}


				public void setPid(int pid) {
					this.pid = pid;
				}


				public String getName() {
					return name;
				}


				public void setName(String name) {
					this.name = name;
				}


				public String getSeller() {
					return seller;
				}


				public void setSeller(String seller) {
					this.seller = seller;
				}


				public String getDescription() {
					return description;
				}


				public void setDescription(String description) {
					this.description = description;
				}


				public String getCategory() {
					return category;
				}


				public void setCategory(String category) {
					this.category = category;
				}


				public float getPrice() {
					return price;
				}


				public void setPrice(float price) {
					this.price = price;
				}


				public boolean isAvailable() {
					return isAvailable;
				}


				public void setAvailable(boolean isAvailable) {
					this.isAvailable = isAvailable;
				}
                  
              
				
				//Comparator
				public static Comparator<Product> ProdPriceComparartor=new Comparator<Product>() {
					
					public int compare(Product p1, Product p2) {
						
						float price1=p1.getPrice();
						float price2=p2.getPrice();
						
						return (Double.compare(price1, price2));
						
					}
				};
				
				
                public static Comparator<Product> ProdNameComparator=new Comparator<Product>() {
                	
                	
                	
                	public int compare(Product p1, Product p2) {
                	
                		String name1=p1.getName();
                		String name2=p2.getName();
                		
                		return (name1.compareToIgnoreCase(name2));
                		
                	}
                	
                };

                
             public static Comparator<Product> ProdCategoryComparator=new Comparator<Product>() {
                	
                	
                	
                	public int compare(Product p1, Product p2) {
                	
                		String category1=p1.getCategory();
                		String category2=p2.getCategory();
                		
                		return (category1.compareToIgnoreCase(category2));
                		
                	}
                	
                };
                
            
                
            public static Comparator<Product> ProdSellerComparator=new Comparator<Product>() {
                	
                	
                	
                	public int compare(Product p1, Product p2) {
                	
                		String seller1=p1.getSeller();
                		String seller2=p2.getSeller();
                		
                		return (seller1.compareToIgnoreCase(seller2));
                		
                	}
                	
                };
                
                
}
